package com.laughing.system.exception;

import com.laughing.common.result.ResultCodeEnum;
import lombok.Getter;

/**
 * @Author: laughing
 * @Create: 2023/10/15 19:01
 * @Description: 自定义异常
 * @Version: 1.0
 */
@Getter
public class AuthException extends RuntimeException {
    private final Integer code;
    private final String message;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param code 状态码
     * @param message 错误消息
     */
    public AuthException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum 结果状态信息
     */
    public AuthException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "AuthException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
