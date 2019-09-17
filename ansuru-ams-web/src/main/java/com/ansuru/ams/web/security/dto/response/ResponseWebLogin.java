package com.ansuru.ams.web.security.dto.response;

import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.svr.user.entity.UserAdmin;

public class ResponseWebLogin{
    private UserAdmin user;

    public UserAdmin getUser() {
        return user;
    }

    public void setUser(UserAdmin user) {
        this.user = user;
    }
}
