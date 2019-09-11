package com.ansuru.ams.web.user.dto;

import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.svr.user.entity.EntityUser;
import com.github.pagehelper.PageInfo;

public class ResponseWebUserFind {
    public PageInfo<EntityUser> pageResult;

    public PageInfo<EntityUser> getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageInfo<EntityUser> pageResult) {
        this.pageResult = pageResult;
    }
}
