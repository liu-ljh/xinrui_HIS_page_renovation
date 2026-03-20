package org.xinrui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xinrui.entity.PatientInfo;

public interface MchiPatientService extends IService<PatientInfo> {

    boolean removeWithCascade(Long oid);
}
