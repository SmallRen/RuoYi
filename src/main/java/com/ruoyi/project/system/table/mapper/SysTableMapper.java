package com.ruoyi.project.system.table.mapper;

import com.ruoyi.project.system.table.domain.SysTable;

import java.util.List;

public interface SysTableMapper {
    List<SysTable> selectList(SysTable sysTable);

    void deleteByIds(Long ids);

    int save(SysTable sysTable);

    int update(SysTable sysTable);

    SysTable find(Long tableId);

    List<SysTable> findTable(Long id);
}
