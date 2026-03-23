package org.xinrui.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * CNV详细记录表（diseaseList+otherDiseaseList合并存储）
 */
@ApiModel(value = "TestCnvInfo", description = "CNV详细记录表")
@Data
@TableName("t_lis_test_cnv")
public class TestCnvInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键", example = "1001")
    private Long oid;

    @ApiModelProperty(value = "结果主键", example = "3001")
    @TableField("result_oid")
    private Long resultOid;

    @ApiModelProperty(value = "类别: D=diseaseList, O=otherDiseaseList", example = "D")
    @TableField("cnv_category")
    private String cnvCategory;

    @ApiModelProperty(value = "区带信息", example = "1p36.33")
    @TableField("cytoband")
    private String cytoband;

    @ApiModelProperty(value = "染色体编号(1-23)", example = "1")
    @TableField(value = "chr_num",insertStrategy = FieldStrategy.IGNORED)
    private Integer chrNum;

    @ApiModelProperty(value = "异常类型 del/dup", example = "dup")
    @TableField("cnv_type")
    private String cnvType;

    @ApiModelProperty(value = "片段大小(M)", example = "2.500")
    @TableField("cnv_size")
    private BigDecimal cnvSize;

    @ApiModelProperty(value = "位点信息", example = "1p36.33-p36.2")
    @TableField("site")
    private String site;

    @ApiModelProperty(value = "CNV缺失重复描述", example = "1p36.33-p36.2缺失")
    @TableField("del_dup_desc")
    private String delDupDesc;

    @ApiModelProperty(value = "疾病名称", example = "智力障碍")
    @TableField("disease_name")
    private String diseaseName;

    @ApiModelProperty(value = "表型", example = "发育迟缓、肌张力低下")
    @TableField("disease_detail")
    private String diseaseDetail;

    @ApiModelProperty(value = "疾病描述", example = "与1p36.33缺失相关")
    @TableField("disease_description")
    private String diseaseDescription;

    @ApiModelProperty(value = "数据版本(审计字段)", example = "0")
    @TableField(value = "intver",insertStrategy = FieldStrategy.IGNORED)
    private Integer intver;

    @ApiModelProperty(value = "最后更新人ID(审计字段)", example = "5001")
    @TableField("updated_by")
    private Long updatedBy;

    @ApiModelProperty(value = "更新时间(审计字段)", example = "2023-08-15T16:00:00")
    @TableField("updated_on")
    private LocalDateTime updatedOn;

    @ApiModelProperty(value = "cnv推送结果原始数据")
    @TableField("result_raw_data")
    private String resultRawData;
}
