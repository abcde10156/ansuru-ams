package com.ansuru.ams.web.common;

public class ErrorCodeWeb {

    private int code = 99999;

    private String errorMessage = "";

    public ErrorCodeWeb(int code, String errorMessage) {
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

    public static ErrorCodeWeb ERROR_INPUT = new ErrorCodeWeb(99999, "");
    public static ErrorCodeWeb ERROR_INTERNAL = new ErrorCodeWeb(99998, "internal error");
}
