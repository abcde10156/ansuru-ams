package com.ansuru.ams.svr.user.dto.response;

import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.svr.user.entity.EntityUser;
import com.github.pagehelper.PageInfo;

public class ResponseSvrUserGet extends Response {
    public EntityUser entityUser;

    public EntityUser getEntityUser() {
        return entityUser;
    }

    public void setEntityUser(EntityUser entityUser) {
        this.entityUser = entityUser;
    }
}
