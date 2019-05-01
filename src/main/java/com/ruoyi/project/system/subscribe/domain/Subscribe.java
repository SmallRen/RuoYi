package com.ruoyi.project.system.subscribe.domain;

import com.ruoyi.project.system.laboratory.domain.Laboratory;
import com.ruoyi.project.system.table.domain.SysTable;

import java.util.Date;

public class Subscribe {
    private Long subscribeId;//subscribe_id
    private Date createTime;//    create_time
    private String tomorrowTime;// subscribe_time
    private String dayTime;// subscribe_time
    private Long userId;//   user_id
    private Long sysLaboratoryLd;// sys_laboratory_id
    private Laboratory laboratory;
    private Long tableId;

    public String getTomorrowTime() {
        return tomorrowTime;
    }

    public void setTomorrowTime(String tomorrowTime) {
        this.tomorrowTime = tomorrowTime;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    private SysTable sysTable;

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public SysTable getSysTable() {
        return sysTable;
    }

    public void setSysTable(SysTable sysTable) {
        this.sysTable = sysTable;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public Long getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Long subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSysLaboratoryLd() {
        return sysLaboratoryLd;
    }

    public void setSysLaboratoryLd(Long sysLaboratoryLd) {
        this.sysLaboratoryLd = sysLaboratoryLd;
    }
}
