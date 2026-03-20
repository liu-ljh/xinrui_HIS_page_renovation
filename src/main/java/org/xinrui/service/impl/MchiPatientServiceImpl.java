package org.xinrui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xinrui.entity.PatientInfo;
import org.xinrui.entity.SampleInfo;
import org.xinrui.mapper.PatientInfoMapper;
import org.xinrui.service.LisSampleService;
import org.xinrui.service.MchiPatientService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MchiPatientServiceImpl extends ServiceImpl<PatientInfoMapper, PatientInfo> implements MchiPatientService {

    @Resource
    private LisSampleService lisSampleService;

    @Override
    @Transactional
    public boolean removeWithCascade(Long oid) {
        // 步骤1: 获取关联的所有样本（通过patient_oid=oid）
        List<SampleInfo> sampleList = lisSampleService.list(
                new QueryWrapper<SampleInfo>().eq("patient_oid", oid)
        );

        // 步骤2: 逐个删除关联的样本（级联删除子表）
        for (SampleInfo sample : sampleList) {
            lisSampleService.removeWithCascade(sample.getOid());
        }

        // 步骤3: 删除患者
        return super.removeById(oid);
    }
}