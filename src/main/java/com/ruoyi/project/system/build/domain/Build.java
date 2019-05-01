package com.ruoyi.project.system.build.domain;

import java.util.Date;

public class Build {

    private Long teachBuildId;
    private String teachBuildLocation;
    private String teachBuildName;
    private String teachBuildImg;
    private String teachBuildLayer;
    private String teachBuildLaboratoryCount;
    private Date createTime;
    private Date updateTime;

    public Long getTeachBuildId() {
        return teachBuildId;
    }

    public void setTeachBuildId(Long teachBuildId) {
        this.teachBuildId = teachBuildId;
    }

    public String getTeachBuildLocation() {
        return teachBuildLocation;
    }

    public void setTeachBuildLocation(String teachBuildLocation) {
        this.teachBuildLocation = teachBuildLocation;
    }

    public String getTeachBuildName() {
        return teachBuildName;
    }

    public void setTeachBuildName(String teachBuildName) {
        this.teachBuildName = teachBuildName;
    }

    public String getTeachBuildImg() {
        return teachBuildImg;
    }

    public void setTeachBuildImg(String teachBuildImg) {
        this.teachBuildImg = teachBuildImg;
    }

    public String getTeachBuildLayer() {
        return teachBuildLayer;
    }

    public void setTeachBuildLayer(String teachBuildLayer) {
        this.teachBuildLayer = teachBuildLayer;
    }

    public String getTeachBuildLaboratoryCount() {
        return teachBuildLaboratoryCount;
    }

    public void setTeachBuildLaboratoryCount(String teachBuildLaboratoryCount) {
        this.teachBuildLaboratoryCount = teachBuildLaboratoryCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
