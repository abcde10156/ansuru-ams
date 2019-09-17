package com.ansuru.ams.svr.user.service;

import com.ansuru.ams.svr.user.dto.request.RequestSvrPagerAsset;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrPagerAsset;
import com.github.pagehelper.PageHelper;

public interface AssetService {
    ResponseSvrPagerAsset listPager(RequestSvrPagerAsset in);
}
