package com.ruoyi.project.system.teachbuild.domain;

import org.apache.shiro.session.mgt.SimpleSession;

public class TeachBuild extends SimpleSession {

    private String teachBuildId;
    private String teachBuildLocation;
    private String teachBuildName;
    private String teachBuildImg;
    private String teachBuildLayer;
    private String teachBuildLaboratoryCount;
    private String createTime;
    private String updateTime;

    public String getTeachBuildId() {
        return teachBuildId;
    }

    public void setTeachBuildId(String teachBuildId) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
