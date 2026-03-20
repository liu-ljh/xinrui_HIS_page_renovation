package org.xinrui.util;

import org.xinrui.util.ConvertUtil;
import org.xinrui.dto.SampleRegistrationDto;
import org.xinrui.entity.ExaminationInfo;
import org.xinrui.entity.PatientInfo;
import org.xinrui.entity.SampleInfo;

import java.time.LocalDateTime;

public class UpdateUtil {
    private static final Long UPDATED_BY = 1L; // 固定更新人ID
    private static final int INVERT = 1; // 固定更新版本值为1

    public static void updateSampleInfo(SampleInfo sampleInfo, SampleRegistrationDto dto, Long patientOid) {
        // 仅更新有值的字段（避免空值覆盖）
        if (dto.getOldSampleNum() != null) {
            sampleInfo.setOldSampleNum(dto.getOldSampleNum());
        }
        if (dto.getSampleType() != null) {
            sampleInfo.setSampleType(Integer.valueOf(dto.getSampleType()));
        }
        if (dto.getShipmentCondition() != null) {
            sampleInfo.setShipmentCondition(Integer.valueOf(dto.getShipmentCondition()));
        }
        if (dto.getTubeType() != null) {
            sampleInfo.setTubeType(Integer.valueOf(dto.getTubeType()));
        }
        if (dto.getProductName() != null) {
            sampleInfo.setProductNo(dto.getProductName());
            sampleInfo.setProductName(dto.getProductName());
        }

        // 保持默认值（即使dto为空也不覆盖）
//        if(sampleInfo.getAdditionalReportFlag() == null){
//            sampleInfo.setAdditionalReportFlag(1);
//        }
//
//        sampleInfo.setRepeatCount(1);
        sampleInfo.setUpdatedBy(UPDATED_BY);
        sampleInfo.setUpdatedOn(LocalDateTime.now());
    }

    public static void updatePatientInfo(PatientInfo patientInfo, SampleRegistrationDto dto) {
        // 仅更新有值的字段
        if (dto.getPhone() != null) {
            patientInfo.setPhone(dto.getPhone());
        }
        if (dto.getIdentity() != null) {
            patientInfo.setIdentity(dto.getIdentity());
        }
        if (dto.getEmergencyContact() != null) {
            patientInfo.setEmergencyContact(dto.getEmergencyContact());
        }
        if (dto.getEmergencyContactPhone() != null) {
            patientInfo.setEmergencyContactPhone(dto.getEmergencyContactPhone());
        }

        patientInfo.setUpdatedBy(UPDATED_BY);
        patientInfo.setUpdatedOn(LocalDateTime.now());
    }

    public static void updateExaminationInfo(ExaminationInfo exam, SampleRegistrationDto dto, Long sampleOid) {
        // 仅更新有值的字段（关键修复：添加空值检查）
        if (dto.getAge() != null) {
            exam.setPatientAge(dto.getAge());
        }
        if (dto.getHeight() != null) {
            exam.setPatientHeight(dto.getHeight());
        }
        if (dto.getWeight() != null) {
            exam.setPatientWeight(dto.getWeight());
        }
        if (dto.getFetusType() != null) {
            exam.setFetusType(Integer.valueOf(dto.getFetusType()));
        }
        if (dto.getGestationalWeeks() != null) {
            exam.setGestationalWeeks(dto.getGestationalWeeks());
        }
        if (dto.getGestationalDays() != null) {
            exam.setGestationalDays(dto.getGestationalDays());
        }
        if (dto.getUsCheck() != null) {
            exam.setBUltrasonography(Integer.valueOf(dto.getUsCheck()));
        }
        if (dto.getIvfFlag() != null) {
            exam.setIvfFlag(dto.getIvfFlag());
        }
        if (dto.getTubebabyType() != null) {
            exam.setTubebabyType(dto.getTubebabyType());
        }
        if (dto.getBhGravidity() != null) {
            exam.setBhGravidity(dto.getBhGravidity());
        }
        if (dto.getBhParity() != null) {
            exam.setBhParity(dto.getBhParity());
        }
        if (dto.getBhOther() != null) {
            exam.setBhOther(dto.getBhOther());
        }
        if (dto.getRemark() != null) {
            exam.setPatientRemark(dto.getRemark());
        }
        if (dto.getDownSymdromeFlag() != null) {
            exam.setDownSymdromeFlag(dto.getDownSymdromeFlag());
        }
        if (dto.getDownSymdromeResult1() != null) {
            exam.setDownSymdromeResult1(dto.getDownSymdromeResult1());
        }
        if (dto.getDownSymdromeResult2() != null) {
            exam.setDownSymdromeResult2(dto.getDownSymdromeResult2());
        }
        if (dto.getDownSymdromeResultOth() != null) {
            exam.setDownSymdromeResultOth(dto.getDownSymdromeResultOth());
        }
        if (dto.getPunctureAppointment() != null) {
            exam.setPunctureAppointment(dto.getPunctureAppointment());
        }
        if (dto.getPunctureAppointmentDate() != null) {
            exam.setPunctureAppointmentDate(ConvertUtil.convertDateTime(dto.getPunctureAppointmentDate()));
        }
        if (dto.getTransplantation() != null) {
            exam.setTransplantation(dto.getTransplantation());
        }
        if (dto.getTransplantationDate() != null) {
            exam.setTransplantationDate(ConvertUtil.convertDateTime(dto.getTransplantationDate()));
        }
        if (dto.getAllogeneicTransfusion() != null) {
            exam.setAllogeneicTransfusion(dto.getAllogeneicTransfusion());
        }
        if (dto.getAllogeneicTransfusionDate() != null) {
            exam.setAllogeneicTransfusionDate(ConvertUtil.convertDateTime(dto.getAllogeneicTransfusionDate()));
        }
        if (dto.getImmunotherapy() != null) {
            exam.setImmunotherapy(dto.getImmunotherapy());
        }
        if (dto.getImmunotherapyDate() != null) {
            exam.setImmunotherapyDate(ConvertUtil.convertDateTime(dto.getImmunotherapyDate()));
        }
        if (dto.getImmunotherapyType() != null) {
            exam.setImmunotherapyType(dto.getImmunotherapyType());
        }
        if (dto.getSpecialCase() != null) {
            exam.setSpecialCase(dto.getSpecialCase());
        }

        if (dto.getUsResult() != null) {
            exam.setUsResult(dto.getUsResult());
        }

        if (dto.getReduceDate() != null) {
            exam.setReduceDate(ConvertUtil.convertDateTime(dto.getReduceDate()));
        }

        // 保持默认更新信息
        exam.setUpdatedBy(UPDATED_BY);
        exam.setUpdatedOn(LocalDateTime.now());
    }
}
