package com.ruoyi.project.system.table.service;

import com.ruoyi.project.system.table.domain.SysTable;

import java.util.List;

public interface ISysTableService {
    List<SysTable> selectList(SysTable sysTable);

    void deleteByIds(Long ids);

    int save(SysTable sysTable);

    int update(SysTable sysTable);


    SysTable find(Long tableId);
}
