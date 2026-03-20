package org.xinrui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xinrui.entity.*;
import org.xinrui.mapper.*;
import org.xinrui.service.LisSampleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LisSampleServiceImpl extends ServiceImpl<SampleInfoMapper, SampleInfo> implements LisSampleService {

    @Resource
    private ExaminationInfoMapper examinationInfoMapper;

    @Resource
    private LaneQcInfoMapper laneQcInfoMapper;

    @Resource
    private SampleQcInfoMapper sampleQcInfoMapper;

    @Resource
    private TestReportFileInfoMapper testReportFileInfoMapper;

    @Resource
    private TestResultInfoMapper testResultInfoMapper;

    @Resource
    private TestCnvInfoMapper testCnvInfoMapper; // 新增：TestCnvInfoMapper

    @Override
    @Transactional
    public boolean removeWithCascade(Long oid) {
        // 步骤1: 先获取关联的TestResultInfo的oid列表（用于删除TestCnvInfo）
        List<TestResultInfo> testResultList = testResultInfoMapper.selectList(
                new QueryWrapper<TestResultInfo>().eq("sample_oid", oid)
        );
        List<Long> resultOidList = testResultList.stream()
                .map(TestResultInfo::getOid)
                .collect(Collectors.toList());

        // 步骤2: 删除TestCnvInfo（关联TestResultInfo的oid）
        if (!resultOidList.isEmpty()) {
            testCnvInfoMapper.delete(new QueryWrapper<TestCnvInfo>().in("result_oid", resultOidList));
        }

        // 步骤3: 删除TestResultInfo（关联样本的oid）
        testResultInfoMapper.delete(new QueryWrapper<TestResultInfo>().eq("sample_oid", oid));

        // 步骤4: 删除其他子表
        examinationInfoMapper.delete(new QueryWrapper<ExaminationInfo>().eq("sample_oid", oid));
        laneQcInfoMapper.delete(new QueryWrapper<LaneQcInfo>().eq("sample_oid", oid));
        sampleQcInfoMapper.delete(new QueryWrapper<SampleQcInfo>().eq("sample_oid", oid));
        testReportFileInfoMapper.delete(new QueryWrapper<TestReportFileInfo>().eq("sample_oid", oid));

        // 步骤5: 删除父表（样本表）
        return super.removeById(oid);
    }
}
