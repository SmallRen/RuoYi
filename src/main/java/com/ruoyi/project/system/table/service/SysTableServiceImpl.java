package com.ruoyi.project.system.table.service;

import com.ruoyi.project.system.table.domain.SysTable;
import com.ruoyi.project.system.table.mapper.SysTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysTableServiceImpl implements ISysTableService {
    @Autowired
    SysTableMapper mapper;
    @Override
    public List<SysTable> selectList(SysTable sysTable) {
        return mapper.selectList(sysTable);
    }

    @Override
    public void deleteByIds(Long ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public int save(SysTable sysTable) {
        return mapper.save(sysTable);
    }

    @Override
    public int update(SysTable sysTable) {
        return mapper.update(sysTable);
    }



    @Override
    public SysTable find(Long tableId) {
        return mapper.find(tableId);
    }
}
