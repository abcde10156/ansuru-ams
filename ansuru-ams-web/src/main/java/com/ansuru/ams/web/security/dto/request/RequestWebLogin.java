package com.ansuru.ams.web.security.dto.request;

import com.ansuru.ams.common.dto.Request;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class RequestWebLogin extends Request {

    @Length(max=6, min=3, message = "请输入3到6位数字")
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
