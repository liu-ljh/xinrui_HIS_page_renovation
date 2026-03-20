package org.xinrui.service;

import org.xinrui.dto.SampleRegistrationDto;
import org.xinrui.entity.PatientInfo;
import org.xinrui.entity.SampleInfo;

public interface SampleService {

    boolean handleSampleRegistrationInfo(SampleRegistrationDto sampleRegistrationDto);

    SampleRegistrationDto getSampleRegistrationBySAId(Long screeningArchivesId);

    PatientInfo handlePatientInfo(SampleRegistrationDto sampleRegistrationDto);

    SampleInfo handleSampleInfo(SampleRegistrationDto sampleRegistrationDto, Long patientOid);

    void handleExaminationInfo(SampleRegistrationDto sampleRegistrationDto, Long sampleOid);




}
