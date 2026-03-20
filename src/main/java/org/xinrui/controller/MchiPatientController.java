package org.xinrui.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.xinrui.dto.ApiResponse;
import org.xinrui.entity.PatientInfo;
import org.xinrui.service.MchiPatientService;

@Slf4j
@RestController
@RequestMapping("/his/V4/lis/patient")
@Api(tags = "患者表接口")
@Validated
public class MchiPatientController {

    @Autowired
    private MchiPatientService mchiPatientService;

    @ApiOperation("新增患者信息")
    @PostMapping("/add")
    public ApiResponse<PatientInfo> addPatient(@RequestBody @Validated PatientInfo patientInfo) {
        boolean success = mchiPatientService.save(patientInfo);
        if (success) {
            return ApiResponse.success(patientInfo);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "新增患者信息失败");
        }
    }

    @ApiOperation("修改患者信息")
    @PutMapping("/update")
    public ApiResponse<Boolean> updatePatient(@RequestBody @Validated PatientInfo patientInfo) {
        boolean success = mchiPatientService.updateById(patientInfo);
        if (success) {
            return ApiResponse.success(true);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "修改患者信息失败");
        }
    }

    @ApiOperation("删除患者信息（物理删除，级联删除关联样本及其子表）")
    @DeleteMapping("/delete/{oid}")
    public ApiResponse<Boolean> deletePatient(@PathVariable Long oid) {
        boolean success = mchiPatientService.removeWithCascade(oid);
        if (success) {
            return ApiResponse.success(true);
        } else {
            return ApiResponse.fail(ApiResponse.DB_ERROR, "删除患者信息失败");
        }
    }

    @ApiOperation("根据ID查询患者信息")
    @GetMapping("/get/{oid}")
    public ApiResponse<PatientInfo> getPatientById(@PathVariable Long oid) {
        PatientInfo patientInfo = mchiPatientService.getById(oid);
        if (patientInfo != null) {
            return ApiResponse.success(patientInfo);
        } else {
            return ApiResponse.fail(ApiResponse.NOT_FOUND, "患者信息不存在");
        }
    }

    @ApiOperation("分页查询患者信息")
    @PostMapping("/list")
    public ApiResponse<Page<PatientInfo>> listPatient(@RequestBody Page<PatientInfo> page) {
        Page<PatientInfo> resultPage = mchiPatientService.page(page);
        return ApiResponse.success(resultPage);
    }
}

