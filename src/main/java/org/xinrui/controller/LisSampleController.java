package org.xinrui.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xinrui.dto.ApiResponse;
import org.xinrui.entity.SampleInfo;
import org.xinrui.service.LisSampleService;

@Slf4j
@RestController
@RequestMapping("/his/V4/lis/sample")
@Api(tags = "样本表接口")
@Validated
public class LisSampleController {

    @Autowired
    private LisSampleService lisSampleService;

    @ApiOperation("新增样本信息")
    @PostMapping("/add")
    public ApiResponse<SampleInfo> addSample(@RequestBody @Validated SampleInfo sampleInfo) {
        boolean success = lisSampleService.save(sampleInfo);
        if (success) {
            return ApiResponse.success(sampleInfo);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "新增样本信息失败");
        }
    }

    @ApiOperation("修改样本信息")
    @PutMapping("/update")
    public ApiResponse<Boolean> updateSample(@RequestBody @Validated SampleInfo sampleInfo) {
        boolean success = lisSampleService.updateById(sampleInfo);
        if (success) {
            return ApiResponse.success(true);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "修改样本信息失败");
        }
    }

    @ApiOperation("删除样本信息（物理删除），级联删除子表")
    @DeleteMapping("/delete/{oid}")
    public ApiResponse<Boolean> deleteSample(@PathVariable Long oid) {
        boolean success = lisSampleService.removeWithCascade(oid);
        if (success) {
            return ApiResponse.success(true);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "删除样本信息失败");
        }
    }

    @ApiOperation("根据ID查询样本信息")
    @GetMapping("/get/{oid}")
    public ApiResponse<SampleInfo> getSampleById(@PathVariable Long oid) {
        SampleInfo sampleInfo = lisSampleService.getById(oid);
        if (sampleInfo != null) {
            return ApiResponse.success(sampleInfo);
        } else {
            return ApiResponse.fail(ApiResponse.NOT_FOUND, "样本信息不存在");
        }
    }

    @ApiOperation("分页查询样本信息")
    @PostMapping("/list")
    public ApiResponse<Page<SampleInfo>> listSample(@RequestBody Page<SampleInfo> page) {
        Page<SampleInfo> resultPage = lisSampleService.page(page);
        return ApiResponse.success(resultPage);
    }
}

