package com.ansuru.ams.svr.user.dto.response;

import com.ansuru.ams.common.dto.Request;
import com.ansuru.ams.svr.user.entity.EntityUser;
import com.github.pagehelper.PageInfo;

public class ResponseSvrUserFind extends Request {
    public PageInfo<EntityUser> pageResult;

    public PageInfo<EntityUser> getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageInfo<EntityUser> pageResult) {
        this.pageResult = pageResult;
    }
}
