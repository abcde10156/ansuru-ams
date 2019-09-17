package com.ansuru.ams.common;


import com.ansuru.ams.common.utils.ErrorCode;

public class ErrorCodeSvr implements ErrorCode {

    private int code = 99999;

    private String errorMessage = "";

    public ErrorCodeSvr(int code, String errorMessage) {
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

    public static ErrorCodeSvr ERROR_USER_NOT_FOUND = new ErrorCodeSvr(1, "user not found");

}
