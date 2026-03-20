package org.xinrui.constant;

import java.util.HashMap;
import java.util.Map;

public class TestConstants {

    // 私有构造方法，防止实例化
    private TestConstants() {}


    /**
     * 用于映射样本类型显示名称到代码 (sample_type)
     */
    public static final Map<String, Integer> SAMPLE_TYPE_CODE_MAP = new HashMap<>();
    static {
        SAMPLE_TYPE_CODE_MAP.put("全血", 1);
        SAMPLE_TYPE_CODE_MAP.put("血浆", 2);
        SAMPLE_TYPE_CODE_MAP.put("DNA", 4);
    }

    /**
     * 用于映射运输条件显示名称到代码 (shipment_condition)
     */
    public static final Map<String, Integer> SHIPMENT_CONDITION_CODE_MAP = new HashMap<>();
    static {
        SHIPMENT_CONDITION_CODE_MAP.put("4°C", 1);
        SHIPMENT_CONDITION_CODE_MAP.put("6~35°C", 2);
        SHIPMENT_CONDITION_CODE_MAP.put("dry ice", 4);
    }

    /**
     * 用于映射采血管类型显示名称到代码 (tube_type)
     */
    public static final Map<String, Integer> TUBE_TYPE_CODE_MAP = new HashMap<>();
    static {
        TUBE_TYPE_CODE_MAP.put("Streck管", 1);
        TUBE_TYPE_CODE_MAP.put("EDTA管", 2);
        TUBE_TYPE_CODE_MAP.put("K管", 4);
        TUBE_TYPE_CODE_MAP.put("G管", 8);
        TUBE_TYPE_CODE_MAP.put("X管", 16);
    }

    /**
     * 用于映射附加报告标志显示名称到代码 (additional_report_flag)
     */
    public static final Map<String, Integer> ADDITIONAL_REPORT_FLAG_CODE_MAP = new HashMap<>();
    static {
        ADDITIONAL_REPORT_FLAG_CODE_MAP.put("是", 1);
        ADDITIONAL_REPORT_FLAG_CODE_MAP.put("否", 2);
    }

    /**
     * 用于映射胎儿类型显示名称到代码 (fetus_type)
     */
    public static final Map<String, Integer> FETUS_TYPE_CODE_MAP = new HashMap<>();
    static {
        FETUS_TYPE_CODE_MAP.put("单胎", 1);
        FETUS_TYPE_CODE_MAP.put("双胎", 2);
    }

    /**
     * 用于映射绒毛膜类型显示名称到代码 (chorion_type)
     */
    public static final Map<String, Integer> CHORION_TYPE_CODE_MAP = new HashMap<>();
    static {
        CHORION_TYPE_CODE_MAP.put("DC", 1);
        CHORION_TYPE_CODE_MAP.put("DA", 2);
        CHORION_TYPE_CODE_MAP.put("MC", 4);
        CHORION_TYPE_CODE_MAP.put("DCDA", 8);
        CHORION_TYPE_CODE_MAP.put("MCMA", 16);
        CHORION_TYPE_CODE_MAP.put("MCDA", 32);
    }

    /**
     * 用于映射B超检查结果显示名称到代码 (b_ultrasonography)
     * 注：实体类中未明确枚举值，此处根据常见业务逻辑假设。
     */
    public static final Map<String, Integer> B_ULTRASONOGRAPHY_CODE_MAP = new HashMap<>();
    static {
        B_ULTRASONOGRAPHY_CODE_MAP.put("正常单活胎", 10);
        B_ULTRASONOGRAPHY_CODE_MAP.put("正常非单胎", 20);
        B_ULTRASONOGRAPHY_CODE_MAP.put("异常单活胎", 30);
    }

    /**
     * 用于映射是否IVF显示名称到代码 (ivf_flag)
     */
    public static final Map<String, Integer> IVF_FLAG_CODE_MAP = new HashMap<>();
    static {
        IVF_FLAG_CODE_MAP.put("是", 1);
        IVF_FLAG_CODE_MAP.put("否", 2);
    }

    /**
     * 用于映射受孕方式显示名称到代码 (conception_method)
     */
    public static final Map<String, Integer> CONCEPTION_METHOD_CODE_MAP = new HashMap<>();
    static {
        CONCEPTION_METHOD_CODE_MAP.put("自然受孕", 1);
        CONCEPTION_METHOD_CODE_MAP.put("IUI", 2);
        CONCEPTION_METHOD_CODE_MAP.put("IVF-ET", 4);
    }

    /**
     * 用于映射是否有效显示名称到代码 (enable)
     */
    public static final Map<String, Integer> ENABLE_CODE_MAP = new HashMap<>();
    static {
        ENABLE_CODE_MAP.put("有效", 1);
        ENABLE_CODE_MAP.put("无效", 0);
    }

    /**
     * 用于映射文件类型显示名称到代码 (file_type)
     */
    public static final Map<String, Integer> FILE_TYPE_CODE_MAP = new HashMap<>();
    static {
        FILE_TYPE_CODE_MAP.put("PDF", 1);
        FILE_TYPE_CODE_MAP.put("WORD", 0);
    }

    /**
     * 用于映射CNV类别显示名称到代码 (cnv_category)
     */
    public static final Map<String, String> CNV_CATEGORY_CODE_MAP = new HashMap<>();
    static {
        CNV_CATEGORY_CODE_MAP.put("疾病列表", "D");
        CNV_CATEGORY_CODE_MAP.put("其他疾病列表", "O");
    }

    /**
     * 用于映射唐筛结果显示名称到代码 (down_screening_result)
     */
    public static final Map<String, Integer> DOWN_SCREENING_RESULT_CODE_MAP = new HashMap<>();
    static {
        DOWN_SCREENING_RESULT_CODE_MAP.put("13-三体，低风险", 1);
        DOWN_SCREENING_RESULT_CODE_MAP.put("13-三体，中风险", 2);
        DOWN_SCREENING_RESULT_CODE_MAP.put("13-三体，高风险", 3);
        DOWN_SCREENING_RESULT_CODE_MAP.put("18-三体，低风险", 4);
        DOWN_SCREENING_RESULT_CODE_MAP.put("18-三体，中风险", 5);
        DOWN_SCREENING_RESULT_CODE_MAP.put("18-三体，高风险", 6);
        DOWN_SCREENING_RESULT_CODE_MAP.put("21-三体，低风险", 7);
        DOWN_SCREENING_RESULT_CODE_MAP.put("21-三体，中风险", 8);
        DOWN_SCREENING_RESULT_CODE_MAP.put("21-三体，高风险", 9);
    }
}
