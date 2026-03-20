package org.xinrui.dto;


import lombok.Data;

/**
 * 样本登记DTO
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 样本登记 DTO
 */
@ApiModel("样本登记信息")
@Data
public class SampleRegistrationDto {


    /** 样本编号/实验编号 */
    @ApiModelProperty(value = "样本编号/实验编号")
    @NotBlank(message = "样本编号/实验编号不能为空")
    private String sampleId;

    /** 原样本编号 */
    @ApiModelProperty(value = "原样本编号")
    private String oldSampleNum;

    /** 年龄（周岁） */
    @ApiModelProperty(value = "年龄（周岁）")
    private Integer age;

    /** 身高（cm） */
    @ApiModelProperty(value = "身高（cm）")
    private BigDecimal height;

    /** 体重（kg） */
    @ApiModelProperty(value = "体重（kg）")
    private BigDecimal weight;

    /** 证件号 */
    @ApiModelProperty(value = "证件号")
    private String identity;

    /** 妊娠史-妊娠次数 */
    @ApiModelProperty(value = "妊娠史-妊娠次数")
    private Integer bhGravidity;

    /** 生育次数 */
    @ApiModelProperty(value = "生育次数")
    private Integer bhParity;

    /** 自然流产次数 */
    @ApiModelProperty(value = "自然流产次数")
    private String bhOther;

    /** 是否为试管婴儿（是:1 / 否:0） */
    @ApiModelProperty(value = "是否为试管婴儿（是:1 / 否:0）")
    private Integer ivfFlag;

    /** 01-自体供卵,02异体供卵 */
    @ApiModelProperty(value = "01-自体供卵,02异体供卵")
    private String tubebabyType;

    /** 胎儿类型（必填，下拉字典值） */
    @NotBlank(message = "胎儿类型不能为空")
    @ApiModelProperty(value = "胎儿类型（必填，下拉字典值）", required = true)
    private String fetusType;

    /** 孕周（必填） */
    @ApiModelProperty(value = "孕周（必填）", required = true)
    private Integer gestationalWeeks;

    /** 孕天（必填） */
    @NotNull(message = "孕天不能为空")
    @ApiModelProperty(value = "孕天（必填）", required = true)
    private Integer gestationalDays;

    /** 样本类型（必填，下拉字典值） */
    @NotNull(message = "样本类型不能为空")
    @ApiModelProperty(value = "样本类型（必填，下拉字典值）", required = true)
    private String sampleType;

    /** 运输条件（必填，下拉字典值） */
    @NotNull(message = "运输条件不能为空")
    @ApiModelProperty(value = "运输条件（必填，下拉字典值）", required = true)
    private String shipmentCondition;

    /** 采血管类型（必填，下拉字典值） */
    @NotBlank(message = "采血管类型不能为空")
    @ApiModelProperty(value = "采血管类型（必填，下拉字典值）", required = true)
    private String tubeType;

    /** 产品套餐（必填，下拉字典值） */
    @NotBlank(message = "产品套餐不能为空")
    @ApiModelProperty(value = "产品套餐（必填，下拉字典值）", required = true)
    private String productName;

    /** 手机号 */
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号")
    private String phone;

    /** 紧急联系人 */
    @ApiModelProperty(value = "紧急联系人")
    private String emergencyContact;

    /** 联系人电话 */
    @ApiModelProperty(value = "联系人电话")
    private String emergencyContactPhone;

    /** 超声检查结果 */
    @ApiModelProperty(value = "超声检查结果，01未见异常，02提示异常")
    private String usCheck;

    /** 超声异常信息 */
    @ApiModelProperty(value = "超声异常信息")
    private String usResult;

    /** 减胎日期 */
    @ApiModelProperty(value = "减胎日期")
    private String reduceDate;

    /** 妊娠情况 */
    @ApiModelProperty(value = "妊娠情况")
    private String pregnancy;

    /** 是否已做唐筛（1-是，0-否） */
    @ApiModelProperty(value = "是否已做唐筛（1-是，0-否）")
    private Integer downSymdromeFlag;

    /** 唐筛风险值 21-三体 */
    @ApiModelProperty(value = "唐筛风险值 21-三体")
    private String downSymdromeResult1;

    /** 唐筛风险值 18-三体 */
    @ApiModelProperty(value = "唐筛风险值 18-三体")
    private String downSymdromeResult2;

    /** 唐筛风险值 其他 */
    @ApiModelProperty(value = "唐筛风险值 其他")
    private String downSymdromeResultOth;

    /** 预约穿刺诊断情况（1-已预约，0-无） */
    @ApiModelProperty(value = "预约穿刺诊断情况（1-已预约，0-无）")
    private Integer punctureAppointment;

    /** 穿刺诊断预约日期 */
    @ApiModelProperty(value = "穿刺诊断预约日期")
    private String punctureAppointmentDate;

    /** 移植手术（1-有，0-无） */
    @ApiModelProperty(value = "移植手术（1-有，0-无）")
    private Integer transplantation;

    /** 移植手术日期 */
    @ApiModelProperty(value = "移植手术日期")
    private String transplantationDate;

    /** 异体输血（1-有，0-无） */
    @ApiModelProperty(value = "异体输血（1-有，0-无）")
    private Integer allogeneicTransfusion;

    /** 异体输血日期 */
    @ApiModelProperty(value = "异体输血日期")
    private String allogeneicTransfusionDate;

    /** 免疫治疗（1-有，0-无） */
    @ApiModelProperty(value = "免疫治疗（1-有，0-无）")
    private Integer immunotherapy;

    /** 免疫治疗日期 */
    @ApiModelProperty(value = "免疫治疗日期")
    private String immunotherapyDate;

    /** 免疫治疗类型 */
    @ApiModelProperty(value = "免疫治疗类型")
    private String immunotherapyType;

    /** 特殊情况 */
    @ApiModelProperty(value = "特殊情况")
    private String specialCase;


    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String remark;

    /** 筛查档案主表主键 */
    @ApiModelProperty(value = "筛查档案主表主键")
    private Long screeningArchivesId;



}
