package org.xinrui.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 患者检查表
 */
@ApiModel(value = "ExaminationInfo", description = "患者检查表")
@Data
@TableName("t_lis_examination")
public class ExaminationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键", example = "1001")
    private Long oid;

    @ApiModelProperty(value = "样本主键", example = "2001")
    @TableField("sample_oid")
    private Long sampleOid;

    @ApiModelProperty(value = "年龄", example = "30")
    @TableField("patient_age")
    private Integer patientAge;

    @ApiModelProperty(value = "身高[0,500]，支持2位小数", example = "175.500")
    @TableField("patient_height")
    private BigDecimal patientHeight;

    @ApiModelProperty(value = "体重[0,500]，支持2位小数", example = "65.250")
    @TableField("patient_weight")
    private BigDecimal patientWeight;

    @ApiModelProperty(value = "预产期", example = "2023-12-15")
    @TableField("patient_edd")
    private LocalDate patientEdd;

    @ApiModelProperty(value = "胎儿类型代码:1. 单胎、2. 双胎", example = "1")
    @TableField("fetus_type")
    private Integer fetusType;

    @ApiModelProperty(value = "孕周（整数）", example = "32")
    @TableField("gestational_weeks")
    private Integer gestationalWeeks;

    @ApiModelProperty(value = "孕天（0-6）", example = "3")
    @TableField("gestational_days")
    private Integer gestationalDays;

    @ApiModelProperty(value = "末次月经", example = "2023-01-10")
    @TableField("last_menstrual_period")
    private LocalDate lastMenstrualPeriod;

    @ApiModelProperty(value = "绒毛膜类型:1. DC、2. DA、4. MC、8. DCDA、16. MCMA、32. MCDA", example = "2")
    @TableField("chorion_type")
    private Integer chorionType;

    @ApiModelProperty(value = "B超检查结果", example = "1")
    @TableField("b_ultrasonography")
    private Integer bUltrasonography;

    @ApiModelProperty(value = "是否IVF Y/N,枚举：1.是、2.否", example = "1")
    @TableField("ivf_flag")
    private Integer ivfFlag;

    @ApiModelProperty(value = "受孕方式：1. 自然受孕、2. IUI、4. IVF-ET", example = "3")
    @TableField("conception_method")
    private Integer conceptionMethod;

    @ApiModelProperty(value = "孕次", example = "2")
    @TableField("bh_gravidity")
    private Integer bhGravidity;

    @ApiModelProperty(value = "产次", example = "1")
    @TableField("bh_parity")
    private Integer bhParity;

    @ApiModelProperty(value = "其他分娩史", example = "剖宫产")
    @TableField("bh_other")
    private String bhOther;

    @ApiModelProperty(value = "羊水穿刺结果", example = "正常")
    @TableField("amniocentesis_result")
    private String amniocentesisResult;

    @ApiModelProperty(value = "既往史", example = "无高血压病史")
    @TableField("illness_history_past")
    private String illnessHistoryPast;

    @ApiModelProperty(value = "现病史/临床诊断", example = "妊娠期糖尿病")
    @TableField("illness_history_present")
    private String illnessHistoryPresent;

    @ApiModelProperty(value = "过敏史", example = "青霉素过敏")
    @TableField("illness_history_allergy")
    private String illnessHistoryAllergy;

    @ApiModelProperty(value = "家族遗传病史", example = "无")
    @TableField("illness_history_genetic")
    private String illnessHistoryGenetic;

    @ApiModelProperty(value = "备注", example = "定期产检")
    @TableField("patient_remark")
    private String patientRemark;

    @ApiModelProperty(value = "数据版本(审计字段)", example = "0")
    @TableField("intver")
    private Integer intver;

    @ApiModelProperty(value = "最后更新人ID(审计字段)", example = "5001")
    @TableField("updated_by")
    private Long updatedBy;

    @ApiModelProperty(value = "更新时间(审计字段)", example = "2023-08-15T16:00:00")
    @TableField("updated_on")
    private LocalDateTime updatedOn;


    @ApiModelProperty(value = "01-自体供卵，02-异体供卵", example = "01")
    @TableField("tubebaby_type")
    private String tubebabyType;

    @ApiModelProperty(value = "01-未见异常，02-提示异常", example = "01")
    @TableField("us_check")
    private String usCheck;

    @ApiModelProperty(value = "超声异常信息", example = "example_value")
    @TableField("us_result")
    private String usResult;

    @ApiModelProperty(value = "减胎日期", example = "2023-10-01 12:00:00")
    @TableField("reduce_date")
    private LocalDateTime reduceDate;

    @ApiModelProperty(value = "是否已做唐筛 1-是 0-否", example = "0")
    @TableField("down_symdrome_flag")
    private Integer downSymdromeFlag;

    @ApiModelProperty(value = "唐筛风险值 21-三体", example = "example_value")
    @TableField("down_symdrome_result1")
    private String downSymdromeResult1;

    @ApiModelProperty(value = "唐筛风险值 18-三体", example = "example_value")
    @TableField("down_symdrome_result2")
    private String downSymdromeResult2;

    @ApiModelProperty(value = "唐筛风险值 其他", example = "example_value")
    @TableField("down_symdrome_result_oth")
    private String downSymdromeResultOth;



    @ApiModelProperty(value = "预约穿刺诊断情况 1-已预约 0-无", example = "0")
    @TableField(value = "puncture_appointment",insertStrategy = FieldStrategy.IGNORED)
    private Integer punctureAppointment;


    @TableField("puncture_appointment_date")
    private LocalDateTime punctureAppointmentDate;

    @ApiModelProperty(value = "移植手术 1-有 0-无", example = "0")
    @TableField(value = "transplantation",insertStrategy = FieldStrategy.IGNORED)
    private Integer transplantation;

    @ApiModelProperty(value = "移植手术日期", example = "2023-10-01 12:00:00")
    @TableField("transplantation_date")
    private LocalDateTime transplantationDate;

    @ApiModelProperty(value = "异体输血 1-有 0-无", example = "0")
    @TableField(value = "allogeneic_transfusion",insertStrategy = FieldStrategy.IGNORED)
    private Integer allogeneicTransfusion;

    @ApiModelProperty(value = "异体输血日期", example = "2023-10-01 12:00:00")
    @TableField("allogeneic_transfusion_date")
    private LocalDateTime allogeneicTransfusionDate;

    @ApiModelProperty(value = "免疫治疗 1-有 0-无", example = "0")
    @TableField(value = "immunotherapy",insertStrategy = FieldStrategy.IGNORED)
    private Integer immunotherapy;

    @ApiModelProperty(value = "免疫治疗日期", example = "2023-10-01 12:00:00")
    @TableField("immunotherapy_date")
    private LocalDateTime immunotherapyDate;

    @ApiModelProperty(value = "免疫治疗类型", example = "example_value")
    @TableField("immunotherapy_type")
    private String immunotherapyType;

    @ApiModelProperty(value = "特殊情况", example = "example_value")
    @TableField("special_case")
    private String specialCase;

    @ApiModelProperty(value = "男方染色体检测：1-已做 2-未做", example = "1")
    @TableField("male_detect_flag")
    private Integer maleDetectFlag;

    @ApiModelProperty(value = "男方检测方法:如果已做，则该字段必填", example = "example_value")
    @TableField("detect_method_male")
    private String detectMethodMale;

    @ApiModelProperty(value = "男方结果:如果已做，则该字段必填", example = "example_value")
    @TableField("detect_result_male")
    private String detectResultMale;

    @ApiModelProperty(value = "女方染色体检测：1-已做 2-未做", example = "1")
    @TableField("female_detect_flag")
    private Integer femaleDetectFlag;

    @ApiModelProperty(value = "女方检测方法:如果已做，则该字段必填", example = "example_value")
    @TableField("detect_method_female")
    private String detectMethodFemale;

    @ApiModelProperty(value = "女方结果:如果已做，则该字段必填", example = "example_value")
    @TableField("detect_result_female")
    private String detectResultFemale;

    @ApiModelProperty(value = "子女染色体检测：1-已做 2-未做", example = "1")
    @TableField("child_detect_flag")
    private Integer childDetectFlag;

    @ApiModelProperty(value = "子女检测方法:如果已做，则该字段必填", example = "example_value")
    @TableField("detect_method_child")
    private String detectMethodChild;

    @ApiModelProperty(value = "子女结果:如果已做，则该字段必填", example = "example_value")
    @TableField("detect_result_child")
    private String detectResultChild;

    @ApiModelProperty(value = "家族史", example = "example_value")
    @TableField("illness_history_genetic_flag")
    private Integer illnessHistoryGeneticFlag;

    @ApiModelProperty(value = "男方疾病既往史", example = "example_value")
    @TableField("illness_history_past_male")
    private String illnessHistoryPastMale;

    @ApiModelProperty(value = "女方疾病既往史", example = "example_value")
    @TableField("illness_history_past_female")
    private String illnessHistoryPastFemale;


    @ApiModelProperty(value = "是否单胎双胎检测", example = "1-是0-否")
    @TableField("fetus_test_flag")
    private Integer fetusTestFlag;

    @ApiModelProperty(value = "超声检测日期")
    @TableField("ultrasound_test_date")
    private String ultrasoundTestDate;
}
