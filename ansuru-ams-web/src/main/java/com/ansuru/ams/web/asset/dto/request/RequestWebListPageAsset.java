package com.ansuru.ams.web.asset.dto.request;

import com.ansuru.ams.common.dto.Request;

import java.util.Date;

public class RequestWebListPageAsset extends Request {

    private int page;

    private int pageSize;

    private String assetCode;

    private String assetName;

    private int cate;

    private int status;

    private Date lentDtStart1;

    private Date lentDtString2;

    private Date lentDtEnd1;

    private Date lentDtEnd2;

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public int getCate() {
        return cate;
    }

    public void setCate(int cate) {
        this.cate = cate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLentDtStart1() {
        return lentDtStart1;
    }

    public void setLentDtStart1(Date lentDtStart1) {
        this.lentDtStart1 = lentDtStart1;
    }

    public Date getLentDtString2() {
        return lentDtString2;
    }

    public void setLentDtString2(Date lentDtString2) {
        this.lentDtString2 = lentDtString2;
    }

    public Date getLentDtEnd1() {
        return lentDtEnd1;
    }

    public void setLentDtEnd1(Date lentDtEnd1) {
        this.lentDtEnd1 = lentDtEnd1;
    }

    public Date getLentDtEnd2() {
        return lentDtEnd2;
    }

    public void setLentDtEnd2(Date lentDtEnd2) {
        this.lentDtEnd2 = lentDtEnd2;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
