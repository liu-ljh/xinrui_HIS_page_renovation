package org.xinrui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Lane质控明细表
 */
@ApiModel(value = "LaneQcInfo", description = "Lane质控明细表")
@Data
@TableName("t_lis_lane_qc")
public class LaneQcInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO) // 数据库自增
    @ApiModelProperty(value = "主键", example = "1001")
    private Long oid;

    @ApiModelProperty(value = "样本主键", example = "2001")
    @TableField("sample_oid")
    private Long sampleOid;

    @ApiModelProperty(value = "lane质控结果", example = "通过")
    @TableField("lane_qc_result")
    private String laneQcResult;

    @ApiModelProperty(value = "质控失败原因", example = "GC含量异常")
    @TableField("lane_qc_reason")
    private String laneQcReason;

    @ApiModelProperty(value = "原始数据量均值(M)", example = "150.7500")
    @TableField("lane_reads_mean")
    private BigDecimal laneReadsMean;

    @ApiModelProperty(value = "比对率(%)", example = "92.3500")
    @TableField("lane_map_rate")
    private BigDecimal laneMapRate;

    @ApiModelProperty(value = "拆分率(%)", example = "98.5000")
    @TableField("total_decode_rate")
    private BigDecimal totalDecodeRate;

    @ApiModelProperty(value = "重复率(%)", example = "15.7500")
    @TableField("lane_duplicate_rate")
    private BigDecimal laneDuplicateRate;

    @ApiModelProperty(value = "Fail_Rate(%)", example = "0.2500")
    @TableField("fail_sample_rate")
    private BigDecimal failSampleRate;

    @ApiModelProperty(value = "GC_mean(%)", example = "45.2500")
    @TableField("lane_gc_mean")
    private BigDecimal laneGcMean;

    @ApiModelProperty(value = "总产量(M)", example = "250.500")
    @TableField("total_reads")
    private BigDecimal totalReads;

    @ApiModelProperty(value = "Q20(%)", example = "85.7500")
    @TableField("q20")
    private BigDecimal q20;

    @ApiModelProperty(value = "Dim_Rate(%)", example = "0.5000")
    @TableField("dim_rate")
    private BigDecimal dimRate;

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
