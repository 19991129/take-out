package com.demo.takeout.pojo.vo;

import com.alibaba.fastjson.JSON;
import com.demo.takeout.constant.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Result<T> implements Serializable {
    public static final long serialVersionUID = 1L;
    private T result;
    private Integer code;
    private String message;
    public Map<String, Object> rtnObj;

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T t) {
        this.code = code;
        this.message = message;
        this.result = t;
    }

    public static Result of(int code, String message) {
        return of(code, message, (Object)null);
    }

    public static <T> Result of(int code, String message, T t) {
        return new Result(code, message, t);
    }

    public static <T> Result success() {
        return of(HttpStatus.OK.value(), "执行成功", (Object)null);
    }

    public static <T> Result success(T t) {
        return of(HttpStatus.OK.value(), "执行成功", t);
    }

    public static <T> Result success(int code, T t) {
        return of(code, "执行成功", t);
    }

    public static <T> Result success(int code, String message, T t) {
        return of(code, message, t);
    }

    public static <T> Result failure() {
        return of(HttpStatus.INTERNAL_SERVER_ERROR.value(), "执行失败", (Object)null);
    }

    public static <T> Result failure(T t) {
        return of(HttpStatus.INTERNAL_SERVER_ERROR.value(), "执行失败", t);
    }

    public static <T> Result failure(int code, T t) {
        return of(code, "执行失败", t);
    }

    public static <T> Result failure(int code, String message, T t) {
        return of(code, message, t);
    }

    public static <T> Result failure(String message) {
        return of(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, (Object)null);
    }

    public static <T> Result DuplicateSubmitError(String message) {
        return of(HttpStatus.DUPLICATE_SUBMIT.value(), message, (Object)null);
    }

    public Result putData(String key, Object value) {
        if (this.rtnObj == null) {
            this.rtnObj = new HashMap();
        }

        this.rtnObj.put(key, value);
        return this;
    }

    public Boolean isSuccess() {
        return HttpStatus.OK.value() == this.code;
    }

    public String toString() {
        return "Result 【code " + this.code + ";message:" + this.message + ";object:" + this.result.toString() + "】";
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public T getResult() {
        return this.result;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Map<String, Object> getRtnObj() {
        return this.rtnObj;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRtnObj(Map<String, Object> rtnObj) {
        this.rtnObj = rtnObj;
    }
}
