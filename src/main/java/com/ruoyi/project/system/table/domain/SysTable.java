package com.ruoyi.project.system.table.domain;

import com.ruoyi.project.system.laboratory.domain.Laboratory;

import java.util.Date;

/*
实验桌实体类
 */
public class SysTable {

    private Long tableId;
    private String tableName;
    private Long tableNumber;
    private Long tableStatus;
    private String tableRemark;
    private Date createTime;
    private Date updateTime;
    private Long laboratoryId;
    private Laboratory laboratory;

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Long getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Long tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getTableRemark() {
        return tableRemark;
    }

    public void setTableRemark(String tableRemark) {
        this.tableRemark = tableRemark;
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

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }
}
