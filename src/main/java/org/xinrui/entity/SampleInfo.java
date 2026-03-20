package org.xinrui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import java.io.Serializable;

/**
 * 样本信息实体类（假设对应sample_info表）,用于去查询数据库获得样本信息
 */
@ApiModel(value = "SampleInfo", description = "样本信息表")
@Data
@TableName("t_lis_sample")
public class SampleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键", example = "1001")
    private Long oid;

    @ApiModelProperty(value = "患者主键", example = "2001")
    @TableField("patient_oid")
    private Long patientOid;

    @ApiModelProperty(value = "筛查档案主表主键", example = "101")
    @TableField("screening_archives_id")
    private Long screeningArchivesId;

    @ApiModelProperty(value = "样本编号", example = "SMP2023001")
    @TableField("sample_id")
    private String sampleId;

    @ApiModelProperty(value = "子文库号", example = "SUB123456")
    @TableField("pooling_sub_id")
    private String poolingSubId;

    @ApiModelProperty(value = "芯片号", example = "SLIDE_001")
    @TableField("slide_id")
    private String slideId;

    @ApiModelProperty(value = "Lane ID", example = "Lane_01")
    @TableField("lane_id")
    private String laneId;

    @ApiModelProperty(value = "DNB ID", example = "DNB_789012")
    @TableField("dnb_id")
    private String dnbId;

    @ApiModelProperty(value = "样本类型代码：无创{1. 全血、2. 血浆、4. DNA}，康孕{1：产前绒毛；2：流产物绒毛；4：胎儿组织；8：羊水；16：脐带血；\n" +
            "32：产前样本DNA；128：产后样本DNA；64：外周血256:羊水培养细胞}", example = "1")
    @TableField("sample_type")
    private Integer sampleType;

    @ApiModelProperty(value = "运输条件：1. 4°C、2. 6~35°C、4. dry ice", example = "1")
    @TableField("shipment_condition")
    private Integer shipmentCondition;

    @ApiModelProperty(value = "采血管类型代码：1. Streck管、2. EDTA管、4. K管、8. G管、16. X管", example = "1")
    @TableField("tube_type")
    private Integer tubeType;

    @ApiModelProperty(value = "取样时间", example = "2023-08-15 14:30:00")
    @TableField("collect_date")
    private LocalDateTime collectDate;

    @ApiModelProperty(value = "收样时间", example = "2023-08-15 15:45:00")
    @TableField("received_date")
    private LocalDateTime receivedDate;

    @ApiModelProperty(value = "原样本编号", example = "OLD_SMP2022")
    @TableField("old_sample_num")
    private String oldSampleNum;

    @ApiModelProperty(value = "附加报告标志 Y/N,枚举：1. 是、2. 否", example = "1")
    @TableField("additional_report_flag")
    private Integer additionalReportFlag;

    @ApiModelProperty(value = "重复次数（>1为重复样本）", example = "1")
    @TableField("repeat_count")
    private Integer repeatCount;

    @ApiModelProperty(value = "产品套餐编号", example = "PROD_2023")
    @TableField("product_no")
    private String productNo;

    @ApiModelProperty(value = "产品套餐名称", example = "全基因组测序套餐")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "门诊号", example = "CLINIC_001")
    @TableField("clinic_num")
    private String clinicNum;

    @ApiModelProperty(value = "送检医院", example = "北京协和医院")
    @TableField("hospital_name")
    private String hospitalName;

    @ApiModelProperty(value = "送检科室", example = "检验科")
    @TableField("department_name")
    private String departmentName;

    @ApiModelProperty(value = "送检医生", example = "张医生")
    @TableField("doctor_name")
    private String doctorName;

    @ApiModelProperty(value = "数据版本(审计字段)", example = "0")
    @TableField("intver")
    private Integer intver;

    @ApiModelProperty(value = "最后更新人ID(审计字段)", example = "5001")
    @TableField("updated_by")
    private Long updatedBy;

    @ApiModelProperty(value = "更新时间(审计字段)", example = "2023-08-15 16:00:00")
    @TableField("updated_on")
    private LocalDateTime updatedOn;

    @ApiModelProperty(value = "送检对象类型:1-胚胎胎儿 2-疑似患者", example = "1")
    @TableField("detect_obj")
    private Integer detectObj;

    @ApiModelProperty(value = "是否录入家系:1-是 0-否", example = "1")
    @TableField("is_save_pedigree")
    private Integer isSavePedigree;

    @ApiModelProperty(value = "先证者样本编号如果是否录入家系选择1；是，则需填写先证者样本编号", example = "SMP2023001")
    @TableField("proband_sample")
    private String probandSample;

    @ApiModelProperty(value = "已知家系关系：1-父亲 2-母亲 4-本人 8-其他", example = "1")
    @TableField("client_relation")
    private Integer clientRelation;

    @ApiModelProperty(value = "受检者类型:1-确诊患者；2-疑似患者；4-表型正常人群；8-其他", example = "1")
    @TableField("client_type")
    private Integer clientType;

    @ApiModelProperty(value = "送检原因：1-无创提示高风险；2-≥35岁孕妇；3-自然流产；4-稽留流", example = "1")
    @TableField("detect_reason")
    private String detectReason;

    @ApiModelProperty(value = "临床诊断;送检单类型为胚胎胎儿则该字段必填", example = "诊断A")
    @TableField("clinical_diagnosis")
    private String clinicalDiagnosis;

    @ApiModelProperty(value = "临床诊断;送检单类型为疑似患者则该字段必填", example = "诊断B")
    @TableField("detect_clinical_diagnosis")
    private String detectClinicalDiagnosis;


}
