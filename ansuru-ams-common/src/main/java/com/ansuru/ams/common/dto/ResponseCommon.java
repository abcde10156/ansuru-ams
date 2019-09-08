package com.ansuru.ams.common.dto;

public class ResponseCommon<T> extends Response{
    private T t;


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static <T> ResponseCommon<T> makeResponse(T t) {
        ResponseCommon<T> responseCommon = new ResponseCommon<>();
        responseCommon.setT(t);
        return responseCommon;
    }
}
