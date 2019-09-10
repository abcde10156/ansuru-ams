package com.ansuru.ams.svr.user.dto.request;

import com.ansuru.ams.common.dto.Request;

public class RequestSvrUserAdminFind extends Request {
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
