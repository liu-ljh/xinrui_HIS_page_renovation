package org.xinrui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 样本检测报告文件表
 */
@ApiModel(value = "TestReportFileInfo", description = "样本检测报告文件表")
@Data
@TableName("t_lis_test_report_file")
public class TestReportFileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键", example = "1001")
    private Long oid;

    @ApiModelProperty(value = "样本主键", example = "2001")
    @TableField("sample_oid")
    private Long sampleOid;

    @ApiModelProperty(value = "文件路径", example = "/reports/2023/SMP2023001.pdf")
    @TableField("file_path")
    private String filePath;

    @ApiModelProperty(value = "文件类型(1为PDF，0为WORD)", example = "1")
    @TableField("file_type")
    private Integer fileType;

    @ApiModelProperty(value = "报告类型", example = "2-无创，1康孕")
    @TableField("report_type")
    private String reportType;

    @ApiModelProperty(value = "数据版本", example = "0")
    @TableField("intver")
    private Integer intver;

    @ApiModelProperty(value = "最后更新人ID", example = "5001")
    @TableField("updated_by")
    private Long updatedBy;

    @ApiModelProperty(value = "更新时间", example = "2023-08-15T16:00:00")
    @TableField("updated_on")
    private java.time.LocalDateTime updatedOn;
}
