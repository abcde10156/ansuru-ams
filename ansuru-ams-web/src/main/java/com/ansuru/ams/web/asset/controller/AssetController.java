package com.ansuru.ams.web.asset.controller;

import com.ansuru.ams.common.dto.Response;
import com.ansuru.ams.svr.user.dto.request.RequestSvrPagerAsset;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrPagerAsset;
import com.ansuru.ams.svr.user.service.AssetService;
import com.ansuru.ams.web.asset.dto.request.RequestWebListPageAsset;
import com.ansuru.ams.web.asset.dto.response.ResponseWebListPageAsset;
import com.ansuru.ams.web.common.BaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("asset")
public class AssetController extends BaseController {

    @Autowired
    private AssetService assetService;

    @RequestMapping("listpager")
    @ResponseBody
    public Response listPageAsset(RequestWebListPageAsset request) {
        RequestSvrPagerAsset dist = new RequestSvrPagerAsset();
        BeanUtils.copyProperties(request, dist);
        ResponseSvrPagerAsset response = assetService.listPager(dist);
        ResponseWebListPageAsset result = new ResponseWebListPageAsset();
        result.setResult(response.getResult());
        return result;
    }
}
