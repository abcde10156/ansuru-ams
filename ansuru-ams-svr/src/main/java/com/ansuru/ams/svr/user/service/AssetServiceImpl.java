package com.ansuru.ams.svr.user.service;

import com.ansuru.ams.svr.user.dao.AssetMapper;
import com.ansuru.ams.svr.user.dto.request.RequestSvrPagerAsset;
import com.ansuru.ams.svr.user.dto.response.ResponseSvrPagerAsset;
import com.ansuru.ams.svr.user.entity.Asset;
import com.ansuru.ams.svr.user.entity.AssetExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetMapper assetMapper;

    @Override
    public ResponseSvrPagerAsset listPager(RequestSvrPagerAsset in) {
        AssetExample assetExample = new AssetExample();
        AssetExample.Criteria criteria = assetExample.createCriteria();
        if(StringUtils.hasText(in.getAssetCode())){
            criteria.andAssetCodeEqualTo(in.getAssetCode());
        }
        PageHelper.startPage(in.getPage(), in.getPageSize());
        List<Asset> assets = assetMapper.selectByExample(assetExample);
        PageInfo<Asset> page = new PageInfo<>(assets);
        ResponseSvrPagerAsset response = new ResponseSvrPagerAsset();
        response.setResult(page);
        return response;
    }
}
