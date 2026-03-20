package org.xinrui.util;

import lombok.extern.slf4j.Slf4j;
import org.xinrui.constant.TestConstants;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ConvertUtil {

    private static final Pattern DATE_PATTERN = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2})");
    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("^(\\d{4}-\\d{2}-\\d{2})");
    private static <T> T convertToCode(Map<String, T> dictMap, String displayName) {
        if (displayName == null || displayName.isEmpty()) {
            return null;
        }
        return dictMap.get(displayName);
    }

    // ==================== 样本信息转换====================
    public static Integer convertSampleType(String type) {
        Integer result = convertToCode(TestConstants.SAMPLE_TYPE_CODE_MAP, type);
        //（ 若SampleType字段缺失或者转换失败，默认为0）
        if(result == null){
            log.warn("SampleType字段缺失或者转换失败{}，默认值为0", type);
            return 0;
        }
        return result;
    }

    public static Integer convertShipmentCondition(String condition) {
        Integer result = convertToCode(TestConstants.SHIPMENT_CONDITION_CODE_MAP, condition);
        //（ 若ShipmentCondition字段缺失或者转换失败，默认为0）
        if(result == null){
            log.warn("ShipmentCondition字段缺失或者转换失败{}，默认值为0", condition);
            return 0;
        }
        return result;
    }

    public static Integer convertTubeType(String tube) {
        Integer result = convertToCode(TestConstants.TUBE_TYPE_CODE_MAP, tube);
        //（ 若TubeType字段缺失或者转换失败，默认为0）
        if(result == null){
            log.warn("TubeType字段缺失或者转换失败{}，默认值为0", tube);
            return 0;
        }
        return result;
    }

    public static Integer convertGestationalWeeks(String weeks) {
        if (weeks == null){
            return null;
        }
        String[] parts = weeks.split(",");
        return Integer.parseInt(parts[0].trim());
    }

    public static Integer convertFetusType(String type) {
        return convertToCode(TestConstants.FETUS_TYPE_CODE_MAP, type);
    }

    // ==================== 检查信息转换 ====================
    public static Integer convertChorion(String chorion) {
        return convertToCode(TestConstants.CHORION_TYPE_CODE_MAP, chorion);
    }

    public static Integer convertBUltrasonography(String result) {
        return convertToCode(TestConstants.B_ULTRASONOGRAPHY_CODE_MAP, result);
    }

    public static Integer convertIvfFlag(String flag) {
        return convertToCode(TestConstants.IVF_FLAG_CODE_MAP, flag);
    }

    public static Integer convertConceptionMethod(String method) {
        return convertToCode(TestConstants.CONCEPTION_METHOD_CODE_MAP, method);
    }

    // ==================== 检测结果转换 ====================
    public static Integer convertDownScreening(String result) {
        return convertToCode(TestConstants.DOWN_SCREENING_RESULT_CODE_MAP, result);
    }



    // ==================== 日期转换 ====================
    public static LocalDateTime convertDateTime(String dateTime) {
        if (dateTime == null || dateTime.trim().isEmpty()) {
            return null;
        }

        // 1. 预处理
        String cleanDate = dateTime.trim();

        // 2. 使用正则提取日期部分 (yyyy-MM-dd)
        Matcher matcher = DATE_TIME_PATTERN.matcher(cleanDate);

        if (!matcher.find()) {
            throw new IllegalArgumentException("日期格式无法识别: " + dateTime);
        }

        String datePart = matcher.group(1); // 得到 "2020-11-12"

        // 3. 智能补全逻辑
        // 尝试直接解析为 LocalDateTime (如果原字符串包含时间，如 "2020-11-12 12:00:00"，这步会成功)
        try {
            // 这里使用 ISO_LOCAL_DATE_TIME，它可以兼容 "yyyy-MM-ddTHH:mm:ss" 或 "yyyy-MM-dd HH:mm:ss"
            return LocalDateTime.parse(cleanDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (Exception e) {
            // 4. 如果上面解析失败（说明只有日期没有时间），手动补上 " 00:00:00"
            // 拼接成 "2020-11-12 00:00:00"
            String fullDateTimeStr = datePart + " 00:00:00";
            return LocalDateTime.parse(fullDateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

    public static LocalDate convertDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            return null;
        }

        // 1. 预处理
        String cleanDate = date.trim();

        // 2. 正则提取日期部分
        // 只要匹配到 yyyy-MM-dd 开头即可，后面的时间部分直接忽略
        Matcher matcher = DATE_PATTERN.matcher(cleanDate);

        if (!matcher.find()) {
            throw new IllegalArgumentException("日期格式无法识别: " + date);
        }

        // 3. 只取日期部分
        String datePart = matcher.group(1);

        // 4. 解析
        return LocalDate.parse(datePart, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // ==================== 数值转换 ====================
    public static BigDecimal convertBigDecimal(Double value) {
        return value == null ? null : BigDecimal.valueOf(value);
    }

    /**
     * 将带单位的字符串转换为BigDecimal
     * 例如："28.39M" -> 28.39
     * @param value 带单位的字符串值
     * @return BigDecimal值，如果输入为null或无法解析则返回null
     */
    public static BigDecimal convertBigDecimal(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        try {
            // 移除所有非数字字符（除了小数点和负号）
            String numericValue = value.replaceAll("[^0-9.-]", "");
            if (numericValue.isEmpty()) {
                return null;
            }
            return new BigDecimal(numericValue);
        } catch (NumberFormatException e) {
            // 如果转换失败，记录日志并返回null
            log.error("string to BigDecimal转换失败: {}", value, e);
            return null;
        }
    }

    // ==================== CNV类别转换 ====================
    public static String convertCnvCategory(String category) {
        return convertToCode(TestConstants.CNV_CATEGORY_CODE_MAP, category);
    }

    // ==================== 检测报告转换(是转化为1，否转化为2，空转化为0) ====================
    public static Integer convertAdditionalReportFlag(String additionalReportFlag) {
        return additionalReportFlag==null?0:convertToCode(TestConstants.ADDITIONAL_REPORT_FLAG_CODE_MAP, additionalReportFlag);
    }
}
