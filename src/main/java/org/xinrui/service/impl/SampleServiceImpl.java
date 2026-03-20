package org.xinrui.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.xinrui.exception.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xinrui.util.ConvertUtil;
import org.xinrui.dto.SampleRegistrationDto;
import org.xinrui.entity.ExaminationInfo;
import org.xinrui.entity.PatientInfo;
import org.xinrui.entity.SampleInfo;
import org.xinrui.exception.BusinessException;
import org.xinrui.mapper.ExaminationInfoMapper;
import org.xinrui.mapper.PatientInfoMapper;
import org.xinrui.mapper.SampleInfoMapper;
import org.xinrui.mapper.SampleMapper;
import org.xinrui.service.SampleService;
import org.xinrui.util.BuildUtil;
import org.xinrui.util.UpdateUtil;

import java.time.LocalDate;

@Slf4j
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleMapper sampleMapper;

    @Autowired
    private PatientInfoMapper patientInfoMapper;

    @Autowired
    private SampleInfoMapper sampleInfoMapper;

    @Autowired
    private ExaminationInfoMapper examinationInfoMapper;


    @Override
    @Transactional
    public boolean handleSampleRegistrationInfo(SampleRegistrationDto sampleRegistrationDto) {
        log.info("样本登记信息处理，样本编号为: {}", sampleRegistrationDto.getSampleId());
        PatientInfo patientInfo = handlePatientInfo(sampleRegistrationDto);
        SampleInfo sampleInfo = handleSampleInfo(sampleRegistrationDto, patientInfo.getOid());
        handleExaminationInfo(sampleRegistrationDto, sampleInfo.getOid());
        return true;
    }

    @Override
    @Transactional
    public PatientInfo handlePatientInfo(SampleRegistrationDto sampleRegistrationDto) {
        PatientInfo patientInfo = null;
        // 1. 根据证件号或手机号查询患者信息
        try {
            patientInfo = patientInfoMapper.selectOne(
                    Wrappers.<PatientInfo>lambdaQuery()
                            .or(query -> query.eq(PatientInfo::getIdentity, sampleRegistrationDto.getIdentity()))
                            .or(query -> query.eq(PatientInfo::getPhone, sampleRegistrationDto.getPhone()))
            );
        } catch (com.baomidou.mybatisplus.core.exceptions.MybatisPlusException e ) {
            // 捕获原始异常，抛出包含详细信息的自定义异常
            // "patient_info" 是数据库表名，"identity/phone" 是查询字段
            throw new TooManyResultsException("t_mchi_patient", "identity/phone");
        }

        if (patientInfo == null) {
            // 2. 如果不存在，则创建新患者
            patientInfo = BuildUtil.buildPatientInfo(sampleRegistrationDto);
            patientInfoMapper.insert(patientInfo);
        } else {
            // 3. 如果存在，则更新患者信息
            UpdateUtil.updatePatientInfo(patientInfo, sampleRegistrationDto);
            patientInfoMapper.updateById(patientInfo);
        }

        return patientInfo;
    }

    @Override
    @Transactional
    public SampleInfo handleSampleInfo(SampleRegistrationDto sampleRegistrationDto, Long patientOid) {
        SampleInfo sampleInfo = null;
        try {
            // 1. 根据样本编号查询样本信息
            sampleInfo = sampleInfoMapper.selectOne(
                    Wrappers.<SampleInfo>lambdaQuery()
                            .eq(SampleInfo::getSampleId, sampleRegistrationDto.getSampleId())
            );
        }catch (com.baomidou.mybatisplus.core.exceptions.MybatisPlusException e ){
            throw new TooManyResultsException("t_lis_sample", "sample_id");
        }



        if (sampleInfo == null) {
            // 2. 如果不存在，则创建新样本
            sampleInfo = BuildUtil.buildSampleInfo(sampleRegistrationDto, patientOid);
            //获取采样时间
            LocalDate collectDate = sampleMapper.selectCollectDateBySAId(sampleInfo.getScreeningArchivesId());
            sampleInfo.setCollectDate(ConvertUtil.convertDateTime(collectDate.toString()));
            sampleInfo.setReceivedDate(ConvertUtil.convertDateTime(collectDate.toString()));
            sampleInfoMapper.insert(sampleInfo);
        } else {
            // 3. 如果存在，则更新样本信息
            UpdateUtil.updateSampleInfo(sampleInfo, sampleRegistrationDto, patientOid);

            sampleInfoMapper.updateById(sampleInfo);
        }

        return sampleInfo;
    }

    @Override
    @Transactional
    public void handleExaminationInfo(SampleRegistrationDto sampleRegistrationDto, Long sampleOid) {
        ExaminationInfo exam = null;
        // 1. 根据sample_oid查询检查信息
        try {
            exam = examinationInfoMapper.selectOne(
                    Wrappers.<ExaminationInfo>lambdaQuery()
                            .eq(ExaminationInfo::getSampleOid, sampleOid)
            );
        }catch (com.baomidou.mybatisplus.core.exceptions.MybatisPlusException e ){
            throw new TooManyResultsException("t_lis_examination", "sample_oid");
        }

        if (exam == null) {
            // 2. 如果不存在，则创建新检查信息
            exam = BuildUtil.buildExaminationInfo(sampleRegistrationDto, sampleOid);
            examinationInfoMapper.insert(exam);
        } else {
            // 3. 如果存在，则更新检查信息
            UpdateUtil.updateExaminationInfo(exam, sampleRegistrationDto, sampleOid);
            examinationInfoMapper.updateById(exam);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public SampleRegistrationDto getSampleRegistrationBySAId(Long screeningArchivesId) {
        if (screeningArchivesId == null) {
            log.warn("筛查档案 ID 不能为空");
            throw new BusinessException("-1", "screeningArchivesId 不能为空");
        }

        // 直接使用多表联查获取数据
        SampleRegistrationDto dto = sampleMapper.selectSampleRegistrationBySAId(screeningArchivesId);

        if (dto == null || dto.getSampleId() == null) {
            log.warn("未找到对应的实验编号，screeningArchivesId: {}", screeningArchivesId);
            throw new BusinessException("-1", "请检查 screeningArchivesId 是否正确");
        }

        String pregnancy = dto.getPregnancy();
        if ("1".equals(pregnancy)) {
            dto.setPregnancy("单胎");
        } else {
            dto.setPregnancy((pregnancy == null || "".equals(pregnancy)) ? "" : "双胎或多胎");
        }

        log.info("样本登记信息查询成功，样本编号：{}", dto.getSampleId());
        return dto;
    }


}
