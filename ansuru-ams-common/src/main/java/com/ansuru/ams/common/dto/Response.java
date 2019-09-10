package com.ansuru.ams.common.dto;

public class Response {

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response() {
    }

    private String requestId;

    private int code;

    private String message = "";

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
