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
 * 样本质控明细表（数值精度保障）
 */
@ApiModel(value = "SampleQcInfo", description = "样本质控明细表")
@Data
@TableName("t_lis_sample_qc")
public class SampleQcInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO) // 数据库自增
    @ApiModelProperty(value = "主键", example = "1001")
    private Long oid;

    @ApiModelProperty(value = "样本主键", example = "2001")
    @TableField("sample_oid")
    private Long sampleOid;

    @ApiModelProperty(value = "样本质控结果", example = "合格")
    @TableField("sample_qc_result")
    private String sampleQcResult;

    @ApiModelProperty(value = "GC含量(%)", example = "45.250")
    @TableField("sample_gc")
    private BigDecimal sampleGc;

    @ApiModelProperty(value = "有效数据量(M)", example = "120.5000")
    @TableField("unique_reads")
    private BigDecimal uniqueReads;

    @ApiModelProperty(value = "原始数据量(M)", example = "150.7500")
    @TableField("reads_num")
    private BigDecimal readsNum;

    @ApiModelProperty(value = "重复率(%)", example = "15.750")
    @TableField("duplication_rate")
    private BigDecimal duplicationRate;

    @ApiModelProperty(value = "比对率(%)", example = "92.3500")
    @TableField("map_rate")
    private BigDecimal mapRate;

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

