package org.xinrui.util;

import org.xinrui.util.ConvertUtil;
import org.xinrui.dto.SampleRegistrationDto;
import org.xinrui.entity.ExaminationInfo;
import org.xinrui.entity.PatientInfo;
import org.xinrui.entity.SampleInfo;

import java.time.LocalDateTime;

public class BuildUtil {
    private static final Long UPDATED_BY = 1L; // 固定更新人ID
    private static final int INVERT = 1; // 数据版本初始值



    public static SampleInfo buildSampleInfo(SampleRegistrationDto dto, Long patientOid) {
        SampleInfo info = new SampleInfo();
        info.setSampleId(dto.getSampleId());
        info.setOldSampleNum(dto.getOldSampleNum());
        info.setPatientOid(patientOid); // 会由handleSampleInfo设置
        info.setScreeningArchivesId(dto.getScreeningArchivesId());
        info.setSampleType(Integer.valueOf(dto.getSampleType()));//需确认返回的是编号还是对应值
        info.setShipmentCondition(Integer.valueOf(dto.getShipmentCondition()));//需确认返回的是编号还是对应值
        info.setTubeType(Integer.valueOf(dto.getTubeType()));//需确认返回的是编号还是对应值
        info.setReceivedDate(null);
        info.setAdditionalReportFlag(1); // 默认为"是"
        info.setRepeatCount(1); // 默认为1
        info.setProductNo(dto.getProductName()); // 产品套餐名称
        info.setProductName(dto.getProductName()); // 产品套餐名称
        info.setClinicNum(null); // 不从DTO获取
        info.setHospitalName(null); // 不从DTO获取
        info.setDepartmentName(null); // 不从DTO获取
        info.setDoctorName(null); // 不从DTO获取

        //下面字段为康孕所需，无创这边做统一处理
//        info.setDetectObj(0);//无创项目暂时填0
//        info.setIsSavePedigree(0);//无创项目暂时填0(当做没有录入家系)
        info.setProbandSample(null);//没有录入家属不用填
//        info.setClientRelation(8);//
//        info.setClientType(8);
        info.setDetectReason(null);
        info.setClinicalDiagnosis(null);
        info.setDetectClinicalDiagnosis(null);
        //结束

        info.setIntver(INVERT);
        info.setUpdatedBy(UPDATED_BY);
        info.setUpdatedOn(LocalDateTime.now());
        return info;
    }

    public static PatientInfo buildPatientInfo(SampleRegistrationDto dto) {
        PatientInfo info = new PatientInfo();
        info.setName(null); // 姓名通常需要从其他来源获取，这里留空
        info.setPhone(dto.getPhone());
        info.setPatientTel(null);
        info.setSex("女"); // 孕检相关，统一设置为女
        info.setBirthday(null); // 出生日期通常需要从其他来源获取
        info.setIdentity(dto.getIdentity());
        info.setIncome(null);
        info.setPermanentAddress(null);
        info.setPermanentAddressDetail(null);
        info.setCurrentAddress(null);
        info.setCurrentAddressDetail(null); // 现住址详情
        info.setEmergencyContact(dto.getEmergencyContact());
        info.setEmergentRelation(null); // 与紧急联系人的关系
        info.setEmergencyContactPhone(dto.getEmergencyContactPhone());
        info.setEnable(1); // 默认有效
        info.setIntver(INVERT);
        info.setCreatedBy(UPDATED_BY);
        info.setCreatedOn(LocalDateTime.now());
        info.setUpdatedBy(UPDATED_BY);
        info.setUpdatedOn(LocalDateTime.now());
        return info;
    }

    public static ExaminationInfo buildExaminationInfo(SampleRegistrationDto dto, Long sampleOid) {
        ExaminationInfo exam = new ExaminationInfo();
        exam.setSampleOid(sampleOid);
        exam.setPatientAge(dto.getAge());
        exam.setPatientHeight(dto.getHeight());
        exam.setPatientWeight(dto.getWeight());
        exam.setPatientEdd(null); // 预产期
        exam.setFetusType(Integer.valueOf(dto.getFetusType()));
        exam.setGestationalWeeks(dto.getGestationalWeeks());
        exam.setGestationalDays(dto.getGestationalDays());
        exam.setLastMenstrualPeriod(null); // 末次月经
        exam.setChorionType(null); // 绒毛膜类型
        exam.setBUltrasonography(null); // B超检查结果
        exam.setUsCheck(dto.getUsCheck());
        exam.setIvfFlag(dto.getIvfFlag());
        exam.setTubebabyType(dto.getTubebabyType());
        exam.setConceptionMethod(null); // 受孕方式
        exam.setBhGravidity(dto.getBhGravidity());
        exam.setBhParity(dto.getBhParity());
        exam.setBhOther(dto.getBhOther());
        exam.setAmniocentesisResult(null); // 羊水穿刺结果
        exam.setIllnessHistoryPast(null); // 既往史
        exam.setIllnessHistoryPresent(null); // 现病史/临床诊断
        exam.setIllnessHistoryAllergy(null); // 过敏史
        exam.setIllnessHistoryGenetic(null); // 家族遗传病史
        exam.setPatientRemark(dto.getRemark());
        exam.setDownSymdromeFlag(dto.getDownSymdromeFlag());
        exam.setDownSymdromeResult1(dto.getDownSymdromeResult1());
        exam.setDownSymdromeResult2(dto.getDownSymdromeResult2());
        exam.setDownSymdromeResultOth(dto.getDownSymdromeResultOth());
        exam.setPunctureAppointment(dto.getPunctureAppointment());
        exam.setPunctureAppointmentDate(ConvertUtil.convertDateTime(dto.getPunctureAppointmentDate()));
        exam.setTransplantation(dto.getTransplantation());
        exam.setTransplantationDate(ConvertUtil.convertDateTime(dto.getTransplantationDate()));
        exam.setAllogeneicTransfusion(dto.getAllogeneicTransfusion());
        exam.setAllogeneicTransfusionDate(ConvertUtil.convertDateTime(dto.getAllogeneicTransfusionDate()));
        exam.setImmunotherapy(dto.getImmunotherapy());
        exam.setImmunotherapyDate(ConvertUtil.convertDateTime(dto.getImmunotherapyDate()));
        exam.setImmunotherapyType(dto.getImmunotherapyType());
        exam.setSpecialCase(dto.getSpecialCase());

        //下面字段为康孕所需，无创这边做统一处理
//        exam.setMaleDetectFlag(0);
        exam.setDetectMethodMale(null);
        exam.setDetectResultMale(null);
//        exam.setFemaleDetectFlag(0);
        exam.setDetectMethodFemale(null);
        exam.setDetectResultFemale(null);
//        exam.setChildDetectFlag(0);
        exam.setDetectMethodChild(null);
        exam.setDetectResultChild(null);
//        exam.setIllnessHistoryGeneticFlag(0);
        exam.setIllnessHistoryPastMale(null);
        exam.setIllnessHistoryPastFemale(null);
        exam.setUltrasoundTestDate( null);
//        exam.setFetusTestFlag(0);
        //结束

        exam.setIntver(INVERT);
        exam.setUpdatedBy(UPDATED_BY);
        exam.setUpdatedOn(LocalDateTime.now());
        return exam;
    }
}
