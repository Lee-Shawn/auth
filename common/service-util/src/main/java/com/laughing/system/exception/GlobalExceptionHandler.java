package com.laughing.system.exception;

import com.laughing.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: laughing
 * @Create: 2023/10/15 18:51
 * @Description: 全局异常处理类
 * @Version: 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕获自定义异常
     * @param e 自定义异常
     * @return 响应数据
     */
    @ExceptionHandler(AuthException.class) // 捕获异常
    @ResponseBody // 响应数据为json格式
    public Result<Object> authException(AuthException e) {
        log.error(e.getMessage(), e);
        return Result.fail().message(e.getMessage()).code(e.getCode());
    }

    /**
     * 捕获全局异常
     * @param e 全局异常
     * @return 响应数据
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> error(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail().message(e.getMessage());
    }
}
