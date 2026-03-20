package org.xinrui.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一API响应封装
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {

    private Integer code;  // 0-成功 非0-失败
    private String msg;   // 返回信息
    private T data;         // 业务数据

    private static final long serialVersionUID = 1L;

    /**
     * 常用错误码
     */
    public static final int SUCCESS = 0;
    public static final int ERROR = -1;
    public static final int DB_ERROR = 1001;
    public static final int NOT_FOUND = 1002;
    public static final int PARAM_ERROR = 1003;

    /**
     * 错误码与错误信息映射
     */
    private static final Map<Integer, String> ERROR_CODE_MAP = new HashMap<>();
    static {
        ERROR_CODE_MAP.put(100909111, "请求参数数值错误，即oldSampleNum和patientIdCard同时为空");
        ERROR_CODE_MAP.put(100909140, "appld不能为空");
        ERROR_CODE_MAP.put(100909141, "appKey不能为空");
        ERROR_CODE_MAP.put(100909142, "产品编号不能为空");
        ERROR_CODE_MAP.put(100909143, "产品编号[%s]不存在");
        ERROR_CODE_MAP.put(100909144, "产品编号[%s]已禁用");
        ERROR_CODE_MAP.put(100909145, "操作人不能为空");
        ERROR_CODE_MAP.put(100909146, "操作人[%s]不存在");
        ERROR_CODE_MAP.put(100909147, "操作人[%s]已禁用");
        ERROR_CODE_MAP.put(100909148, "推送样本失败");
        ERROR_CODE_MAP.put(100510106, "无产品权限");
        ERROR_CODE_MAP.put(100510108, "token非法或失效");
        ERROR_CODE_MAP.put(100510109, "token为空");
        ERROR_CODE_MAP.put(100110101, "请求参数异常");
        ERROR_CODE_MAP.put(100110103, "请求的资源不存在");
        ERROR_CODE_MAP.put(100110104, "服务器异常");
        ERROR_CODE_MAP.put(300510002, "没有报告文件");
        ERROR_CODE_MAP.put(300510003, "解析参数异常,创建失败");
        ERROR_CODE_MAP.put(400220101, "没有报告文件");
        ERROR_CODE_MAP.put(400410153, "创建样本失败,请检查参数");
        ERROR_CODE_MAP.put(400410155, "产品编号或样本设定不可编辑");

        // 添加常用错误信息
        ERROR_CODE_MAP.put(DB_ERROR, "数据库操作失败");
        ERROR_CODE_MAP.put(NOT_FOUND, "请求的资源不存在");
        ERROR_CODE_MAP.put(PARAM_ERROR, "请求参数错误");
    }

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(SUCCESS);
        response.setMsg("请求成功");
        response.setData(data);
        return response;
    }

    public static ApiResponse success() {
        ApiResponse response = new ApiResponse<>();
        response.setCode(SUCCESS);
        response.setMsg("请求成功");
        // result 默认为 null，JSON 序列化时通常会被忽略
        return response;
    }

    public static <T> ApiResponse<T> fail(int code, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(code);
        response.setMsg(message);
        return response;
    }

    public static <T> ApiResponse<T> fail(String message) {
        return fail(ERROR, message);
    }

    /**
     * 根据错误码获取标准化错误描述
     * @param code 错误码
     * @return 标准化错误信息
     */
    public static String getStandardErrorMsg(Integer code) {
        if (ERROR_CODE_MAP.containsKey(code)) {
            return ERROR_CODE_MAP.get(code);
        } else {
            return "未知错误[" + code + "]";
        }
    }
}
