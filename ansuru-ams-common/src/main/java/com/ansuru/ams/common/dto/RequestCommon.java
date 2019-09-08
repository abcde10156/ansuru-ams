package com.ansuru.ams.common.dto;

public class RequestCommon<T> extends Request {
    private T t;


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static <T> RequestCommon<T> makeRequest(T t) {
        RequestCommon<T> requestCommon = new RequestCommon<>();
        requestCommon.setT(t);
        return requestCommon;
    }
}
