package com.ansuru.ams.svr.user.entity;

import java.util.Date;

public class Asset {
    private Integer id;

    private String assetCode;

    private String assetName;

    private Short assetCate;

    private Short usedStatus;

    private String lentUser;

    private Date lentStartDt;

    private Date lentEndDt;

    private String note;

    private String deleteFlag;

    private Date createdDt;

    private String createdName;

    private Date modifiedDt;

    private String modifiedName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode == null ? null : assetCode.trim();
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public Short getAssetCate() {
        return assetCate;
    }

    public void setAssetCate(Short assetCate) {
        this.assetCate = assetCate;
    }

    public Short getUsedStatus() {
        return usedStatus;
    }

    public void setUsedStatus(Short usedStatus) {
        this.usedStatus = usedStatus;
    }

    public String getLentUser() {
        return lentUser;
    }

    public void setLentUser(String lentUser) {
        this.lentUser = lentUser == null ? null : lentUser.trim();
    }

    public Date getLentStartDt() {
        return lentStartDt;
    }

    public void setLentStartDt(Date lentStartDt) {
        this.lentStartDt = lentStartDt;
    }

    public Date getLentEndDt() {
        return lentEndDt;
    }

    public void setLentEndDt(Date lentEndDt) {
        this.lentEndDt = lentEndDt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    public Date getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        this.modifiedDt = modifiedDt;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public void setModifiedName(String modifiedName) {
        this.modifiedName = modifiedName == null ? null : modifiedName.trim();
    }
}