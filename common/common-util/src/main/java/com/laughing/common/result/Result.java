package com.laughing.common.result;

import lombok.Data;

/**
 * @Author: laughing
 * @Create: 2023/10/15 11:25
 * @Description: 全局统一返回结果类
 * @Version: 1.0
 */
@Data
public class Result<T> {
    // 响应码
    private Integer code;
    // 响应消息
    private String message;
    // 响应数据
    private T data;

    /**
     * 返回数据
     * @param data 响应数据
     * @return Result
     * @param <T> 泛型
     */
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    /**
     * 自定义响应码和信息
     * @param body 响应数据
     * @param code 自定义响应码
     * @param message 自定义响应消息
     * @return Result
     * @param <T> 泛型
     */
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 返回指定的响应码和信息
     * @param body 响应数据
     * @param resultCodeEnum 指定响应信息
     * @return Result
     * @param <T> 泛型
     */
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 操作成功返回数据
     * @param data 响应数据
     * @param <T> 泛型
     * @return Result
     */
    public static<T> Result<T> success(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }

    /**
     * 操作成功不返回数据
     * @return Result
     * @param <T> 泛型
     */
    public static<T> Result<T> success(){
        return Result.success(null);
    }

    /**
     * 操作失败不返回数据
     * @return Result
     * @param <T> 泛型
     */
    public static<T> Result<T> fail(){
        return Result.fail(null);
    }

    /**
     * 操作失败返回数据
     * @param data 响应数据
     * @param <T> 泛型
     * @return Result
     */
    public static<T> Result<T> fail(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.FAIL);
    }

    /**
     * 自定义返回信息
     * @param msg 自定义信息
     * @return Result
     */
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    /**
     * 自定义响应码
     * @param code 自定义响应码
     * @return Result
     */
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
