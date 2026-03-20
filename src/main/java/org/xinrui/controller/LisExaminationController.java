package org.xinrui.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xinrui.dto.ApiResponse;
import org.xinrui.entity.ExaminationInfo;
import org.xinrui.service.LisExaminationService;

@Slf4j
@RestController
@RequestMapping("/his/V4/lis/examination")
@Api(tags = "检查表接口")
@Validated
public class LisExaminationController {
    @Autowired
    private LisExaminationService lisExaminationService;

    @ApiOperation("新增检查信息")
    @PostMapping("/add")
    public ApiResponse<ExaminationInfo> addExamination(@RequestBody @Validated ExaminationInfo examinationInfo) {
        boolean success = lisExaminationService.save(examinationInfo);
        if (success) {
            return ApiResponse.success(examinationInfo);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "新增检查信息失败");
        }
    }

    @ApiOperation("修改检查信息")
    @PutMapping("/update")
    public ApiResponse<Boolean> updateExamination(@RequestBody @Validated ExaminationInfo examinationInfo) {
        boolean success = lisExaminationService.updateById(examinationInfo);
        if (success) {
            return ApiResponse.success(true);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "修改检查信息失败");
        }
    }

    @ApiOperation("删除检查信息（物理删除）")
    @DeleteMapping("/delete/{oid}")
    public ApiResponse<Boolean> deleteExamination(@PathVariable Long oid) {
        boolean success = lisExaminationService.removeById(oid);
        if (success) {
            return ApiResponse.success(true);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "删除检查信息失败");
        }
    }

    @ApiOperation("根据ID查询检查信息")
    @GetMapping("/get/{oid}")
    public ApiResponse<ExaminationInfo> getExaminationById(@PathVariable Long oid) {
        ExaminationInfo examinationInfo = lisExaminationService.getById(oid);
        if (examinationInfo != null) {
            return ApiResponse.success(examinationInfo);
        } else {
            return ApiResponse.fail(ApiResponse.NOT_FOUND, "检查信息不存在");
        }
    }

    @ApiOperation("分页查询检查信息")
    @PostMapping("/list")
    public ApiResponse<Page<ExaminationInfo>> listExamination(@RequestBody Page<ExaminationInfo> page) {
        Page<ExaminationInfo> resultPage = lisExaminationService.page(page);
        return ApiResponse.success(resultPage);
    }
}
