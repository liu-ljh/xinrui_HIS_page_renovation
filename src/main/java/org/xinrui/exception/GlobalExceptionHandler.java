package org.xinrui.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xinrui.dto.ApiResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 业务异常
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> handleBusinessException(BusinessException e) {
        log.warn("业务异常: [{}] {}", e.getCode(), e.getMessage());
        return ApiResponse.fail(Integer.parseInt(e.getCode()), e.getMessage());
    }

    // Validation参数校验异常（@Valid）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> handleValidationException(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));
        log.warn("参数校验失败: {}", errorMsg);
        return ApiResponse.fail(-1, "请求失败");
    }

    // PathVariable校验异常（@NotBlank等）
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> handleConstraintViolationException(ConstraintViolationException e) {
        String errorMsg = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining("; "));
        log.warn("路径参数校验失败: {}", errorMsg);
        return ApiResponse.fail(-1, "请求失败");
        //目前只有对于RequestSampleController中getSampleInfo方法可能出现该异常，即确保请求参数不为空
    }

    // Spring 文件上传异常（如文件超限）
    @ExceptionHandler(org.springframework.web.multipart.MaxUploadSizeExceededException.class)
    public ApiResponse<Void> handleMaxSize(Exception ex, HttpServletRequest req) {
        log.error("文件超过大小限制", ex);
        return ApiResponse.fail(-1, "请求失败");
    }

    @ExceptionHandler(NumberFormatException.class)
    public ApiResponse<Void> handleNumberFormatException(NumberFormatException ex) {
        log.error("数字格式异常(应为String转Integer出错)", ex);
        return ApiResponse.fail(-1, "请求失败");
    }

    @ExceptionHandler(org.xinrui.exception.TooManyResultsException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> handleTooManyResultsException(TooManyResultsException e) {
        // e.getMessage() 里面已经包含了我们格式化好的详细错误信息
        log.warn("业务逻辑异常: {}", e.getMessage());
        return ApiResponse.fail(-1, e.getMessage());
    }


    // 系统异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Void> handleException(Exception e) {
        log.error("系统异常", e);
        return ApiResponse.fail(-1, "系统繁忙，请稍后再试");
    }



}
