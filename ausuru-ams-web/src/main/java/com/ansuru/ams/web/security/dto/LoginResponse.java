package com.ansuru.ams.web.security.dto;

import com.ansuru.ams.common.dto.Response;

public class LoginResponse extends Response {
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
