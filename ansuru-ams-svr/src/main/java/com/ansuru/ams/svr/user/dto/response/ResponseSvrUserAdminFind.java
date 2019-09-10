package com.ansuru.ams.svr.user.dto.response;

import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.svr.user.entity.UserAdmin;

public class ResponseSvrUserAdminFind extends Response {
    private UserAdmin userAdmin;

    public UserAdmin getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(UserAdmin userAdmin) {
        this.userAdmin = userAdmin;
    }
}
