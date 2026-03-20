package org.xinrui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.xinrui.entity.ExaminationInfo;
import org.xinrui.mapper.ExaminationInfoMapper;
import org.xinrui.service.LisExaminationService;

@Service
public class LisExaminationServiceImpl extends ServiceImpl<ExaminationInfoMapper, ExaminationInfo> implements LisExaminationService {
}
