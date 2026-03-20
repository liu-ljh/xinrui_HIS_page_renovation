package org.xinrui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 患者信息表
 */
@ApiModel(value = "PatientInfo", description = "患者临床信息表")
@Data
@TableName("t_mchi_patient")
public class PatientInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "患者基本信息id", example = "1001")
    private Long oid;

    @ApiModelProperty(value = "姓名", example = "张三")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "手机号", example = "13800138000")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "家庭电话", example = "010-88889999")
    @TableField("patient_tel")
    private String patientTel;

    @ApiModelProperty(value = "性别", example = "女")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "出生日期", example = "1990-01-01")
    @TableField("birthday")
    private LocalDate birthday;

    @ApiModelProperty(value = "身份证号", example = "110101199001011234")
    @TableField("identity")
    private String identity;

    @ApiModelProperty(value = "收入", example = "8000")
    @TableField("income")
    private String income;

    @ApiModelProperty(value = "常住地址", example = "北京市")
    @TableField("permanent_address")
    private String permanentAddress;

    @ApiModelProperty(value = "常住地址详情", example = "海淀区中关村大街1号")
    @TableField("permanent_address_detail")
    private String permanentAddressDetail;

    @ApiModelProperty(value = "现住址", example = "北京市")
    @TableField("current_address")
    private String currentAddress;

    @ApiModelProperty(value = "现住址详情", example = "朝阳区建国门外大街2号")
    @TableField("current_address_detail")
    private String currentAddressDetail;

    @ApiModelProperty(value = "紧急联系人", example = "李四")
    @TableField("emergency_contact")
    private String emergencyContact;

    @ApiModelProperty(value = "与紧急联系人的关系", example = "丈夫")
    @TableField("emergent_relation")
    private String emergentRelation;

    @ApiModelProperty(value = "紧急联系人电话", example = "13900139000")
    @TableField("emergency_contact_phone")
    private String emergencyContactPhone;

    @ApiModelProperty(value = "创建人", example = "1000")
    @TableField("created_by")
    private Long createdBy;

    @ApiModelProperty(value = "创建时间", example = "2023-08-15T10:00:00")
    @TableField("created_on")
    private LocalDateTime createdOn;

    @ApiModelProperty(value = "修改人", example = "1001")
    @TableField("updated_by")
    private Long updatedBy;

    @ApiModelProperty(value = "修改时间", example = "2023-08-15T16:00:00")
    @TableField("updated_on")
    private LocalDateTime updatedOn;

    @ApiModelProperty(value = "是否有效", example = "1")
    @TableField("enable")
    private Integer enable;

    @ApiModelProperty(value = "数据版本", example = "0")
    @TableField("intver")
    private Integer intver;
}