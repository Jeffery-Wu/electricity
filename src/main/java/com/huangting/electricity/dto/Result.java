package com.huangting.electricity.dto;

/**
 * Created by huangting on 2017/6/20.
 */
public class Result<T> {

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 请求的响应信息
     */
    private String message;

    /**
     * 请求的响应数据
     */
    private T data;

    public Result(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
