package com.ansuru.ams.svr.user.dto.response;

import com.ansuru.ams.common.dto.Request;
import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.svr.user.entity.Asset;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.Date;

public class ResponseSvrPagerAsset extends Response {
    PageInfo<Asset> result;

    public PageInfo<Asset> getResult() {
        return result;
    }

    public void setResult(PageInfo<Asset> result) {
        this.result = result;
    }
}
