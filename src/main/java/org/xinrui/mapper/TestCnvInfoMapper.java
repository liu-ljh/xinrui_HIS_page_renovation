package org.xinrui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.xinrui.entity.TestCnvInfo;

import java.util.List;

@Mapper
public interface TestCnvInfoMapper extends BaseMapper<TestCnvInfo> {
    /**
     * 批量插入CNV信息
     * @param list CNV信息列表
     * @return 影响行数
     */
    int insertBatch(@Param("list") List<TestCnvInfo> list);
}