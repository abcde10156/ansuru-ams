package com.ansuru.ams.web.user.dto;

import com.ansuru.ams.common.dto.Request;

public class RequestWebUserFind extends Request {
    private int pageNo;

    private int pageSize;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
