package org.xinrui.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 检测核心结果表
 */
@ApiModel(value = "TestResultInfo", description = "检测核心结果表")
@Data
@TableName("t_lis_test_result")
public class TestResultInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(type = IdType.AUTO) // 数据库自增
    @ApiModelProperty(value = "主键", example = "1001")
    private Long oid;

    @ApiModelProperty(value = "样本主键", example = "2001")
    @TableField("sample_oid")
    private Long sampleOid;

    @ApiModelProperty(value = "检测时间", example = "2023-08-15T14:30:00")
    @TableField("test_time")
    private LocalDateTime testTime;

    @ApiModelProperty(value = "检测结果", example = "低风险")
    @TableField("test_result")
    private String testResult;

    @ApiModelProperty(value = "报告类型", example = "常规报告")
    @TableField("report_type")
    private String reportType;

    @ApiModelProperty(value = "报告创建时间", example = "2023-08-15T15:45:00")
    @TableField("report_create_time")
    private LocalDateTime reportCreateTime;

    @ApiModelProperty(value = "唐筛结果：13-三体，低风险、13-三体，中风险、13-三体，高风险、18-三体，低风险、18-三体，中风险、18-三体，高风险、\n" +
            "21-三体，低风险、21-三体，中风险、21-三体，高风险", example = "1")
    @TableField(value = "down_screening_result",insertStrategy = FieldStrategy.IGNORED)
    private Integer downScreeningResult;

    @ApiModelProperty(value = "13 三体 检测值", example = "0.0050")
    @TableField("z_chr13")
    private BigDecimal zChr13;

    @ApiModelProperty(value = "18 三体 检测值", example = "0.0030")
    @TableField("z_chr18")
    private BigDecimal zChr18;

    @ApiModelProperty(value = "21 三体 检测值", example = "0.0025")
    @TableField("z_chr21")
    private BigDecimal zChr21;

    @ApiModelProperty(value = "13号染色体风险判定", example = "低风险")
    @TableField("test_chr13")
    private String testChr13;

    @ApiModelProperty(value = "18号染色体风险判定", example = "低风险")
    @TableField("test_chr18")
    private String testChr18;

    @ApiModelProperty(value = "21号染色体风险判定", example = "低风险")
    @TableField("test_chr21")
    private String testChr21;

    @ApiModelProperty(value = "性染色体结果", example = "正常")
    @TableField("test_chr_sex")
    private String testChrSex;

    @ApiModelProperty(value = "性染色体异常提示", example = "无")
    @TableField("abnormal_chr_x")
    private String abnormalChrX;

    @ApiModelProperty(value = "性染色体浓度差", example = "0.0010")
    @TableField("frac_abs")
    private BigDecimal fracAbs;

    @ApiModelProperty(value = "胎儿浓度(%)", example = "98.5000")
    @TableField("fetal_faction")
    private BigDecimal fetalFaction;

    @ApiModelProperty(value = "13号染色体浓度(%)", example = "1.2000")
    @TableField("child_lv_chr13")
    private BigDecimal childLvChr13;

    @ApiModelProperty(value = "18号染色体浓度(%)", example = "1.1000")
    @TableField("child_lv_chr18")
    private BigDecimal childLvChr18;

    @ApiModelProperty(value = "21号染色体浓度(%)", example = "1.0500")
    @TableField("child_lv_chr21")
    private BigDecimal childLvChr21;

    @ApiModelProperty(value = "13号染色体风险值", example = "1:1000")
    @TableField("risk_index_13")
    private String riskIndex13;

    @ApiModelProperty(value = "18号染色体风险值", example = "1:2000")
    @TableField("risk_index_18")
    private String riskIndex18;

    @ApiModelProperty(value = "21号染色体风险值", example = "1:3000")
    @TableField("risk_index_21")
    private String riskIndex21;

    @ApiModelProperty(value = "Test(缺失重复)", example = "无异常")
    @TableField("test_deletion_duplication")
    private String testDeletionDuplication;

    @ApiModelProperty(value = "其他常染色体异常", example = "无")
    @TableField("test_chr_other")
    private String testChrOther;

    @ApiModelProperty(value = "异常染色体计数", example = "0")
    @TableField(value = "abnormal_chr_num",insertStrategy = FieldStrategy.IGNORED)
    private Integer abnormalChrNum;

    @ApiModelProperty(value = "补充信息", example = "建议定期复查")
    @TableField("extra_information")
    private String extraInformation;

    @ApiModelProperty(value = "操作建议", example = "常规产检")
    @TableField("recommended_operation")
    private String recommendedOperation;

    @ApiModelProperty(value = "医生意见", example = "结果正常")
    @TableField("doctor_opinion")
    private String doctorOpinion;

    @ApiModelProperty(value = "数据版本(审计字段)", example = "0")
    @TableField("intver")
    private Integer intver;

    @ApiModelProperty(value = "最后更新人ID(审计字段)", example = "5001")
    @TableField("updated_by")
    private Long updatedBy;

    @ApiModelProperty(value = "更新时间(审计字段)", example = "2023-08-15T16:00:00")
    @TableField("updated_on")
    private LocalDateTime updatedOn;
}

