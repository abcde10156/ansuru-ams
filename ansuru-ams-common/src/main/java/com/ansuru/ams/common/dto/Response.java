package com.ansuru.ams.common.dto;

public class Response<T> {

    public class Meta {

        public Meta(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Meta() {
        }

        private int code;

        private String traceNo;

        private String msg = "";

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getTraceNo() {
            return traceNo;
        }

        public void setTraceNo(String traceNo) {
            this.traceNo = traceNo;
        }
    }

    private Meta meta;

    public Response(int code, String message) {
        this.meta = new Meta(code, message);
    }

    public Response() {
        this.meta = new Meta();
    }

    public Meta getMeta() {
        return meta;
    }

    private void setMeta(Meta meta) {
        this.meta = meta;
    }

    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Response makeResponse(T data) {
        Response<T> responseCommon = new Response<>();
        responseCommon.setData(data);
        return responseCommon;
    }

    public static <T> Response makeErrorResponse(int code, String msg) {
        Response<T> responseCommon = new Response<>(code, msg);
        return responseCommon;
    }

    public static <T> Response makeErrorResponse(int code, String msg, T result) {
        Response<T> responseCommon = new Response<>(code, msg);
        responseCommon.setData(result);
        return responseCommon;
    }
}
