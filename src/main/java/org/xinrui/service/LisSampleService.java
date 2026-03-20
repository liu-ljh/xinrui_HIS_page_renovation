package org.xinrui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.xinrui.entity.SampleInfo;

public interface LisSampleService extends IService<SampleInfo> {

    boolean removeWithCascade(Long oid);
}
