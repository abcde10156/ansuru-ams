package com.ansuru.ams.web.security.dto.request;

import com.ansuru.ams.common.dto.Request;

import java.util.Date;

public class RequestWebLogin extends Request {
    public String username;

    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
