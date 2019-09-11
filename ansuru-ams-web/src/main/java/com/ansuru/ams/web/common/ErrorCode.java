package com.ansuru.ams.web.common;

public class ErrorCode {

    private int code = 99999;

    private String errorMessage = "";

    public ErrorCode(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ErrorCode ERROR_INPUT = new ErrorCode(99999, "");
    public static ErrorCode ERROR_INTERNAL = new ErrorCode(99998, "internal error");
}
