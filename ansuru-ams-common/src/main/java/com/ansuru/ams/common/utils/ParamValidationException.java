package com.ansuru.ams.common.utils;

public class ParamValidationException extends RuntimeException{
    private int code;

    private String msg;

    public ParamValidationException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
