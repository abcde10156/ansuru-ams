package com.ansuru.ams.svr.user.dto.request;

import com.ansuru.ams.common.dto.Request;

public class RequestSvrUserGet extends Request {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
