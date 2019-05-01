package com.ruoyi.project.system.laboratory.domain;

import com.ruoyi.project.system.build.domain.Build;
import com.ruoyi.project.system.dept.domain.Dept;
import org.apache.shiro.session.mgt.SimpleSession;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 实验室实体类
 */
public class Laboratory extends SimpleSession {
    private Long laboratoryId;
    private String laboratoryLocation;
    private String laboratoryType;
    private String laboratoryNumber;
    private Long deptId;
    private Long teachBuildId;
    private Long laboratorySeating;
    private String laboratoryImg;
    private Date createTime;
    private Dept dept;
    private Build teachBuild;

    public String getLaboratoryImg() {
        return laboratoryImg;
    }

    public Long getLaboratorySeating() {
        return laboratorySeating;
    }

    public void setLaboratorySeating(Long laboratorySeating) {
        this.laboratorySeating = laboratorySeating;
    }

    public void setLaboratoryImg(String laboratoryImg) {
        this.laboratoryImg = laboratoryImg;
    }

    public Long getTeachBuildId() {
        return teachBuildId;
    }

    public Build getTeachBuild() {
        return teachBuild;
    }

    public void setTeachBuild(Build teachBuild) {
        this.teachBuild = teachBuild;
    }

    public void setTeachBuildId(Long teachBuildId) {
        this.teachBuildId = teachBuildId;
    }

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getLaboratoryLocation() {
        return laboratoryLocation;
    }

    public void setLaboratoryLocation(String laboratoryLocation) {
        this.laboratoryLocation = laboratoryLocation;
    }

    public String getLaboratoryType() {
        return laboratoryType;
    }

    public void setLaboratoryType(String laboratoryType) {
        this.laboratoryType = laboratoryType;
    }

    public String getLaboratoryNumber() {
        return laboratoryNumber;
    }

    public void setLaboratoryNumber(String laboratoryNumber) {
        this.laboratoryNumber = laboratoryNumber;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
