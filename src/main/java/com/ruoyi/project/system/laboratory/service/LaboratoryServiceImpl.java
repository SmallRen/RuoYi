package com.ruoyi.project.system.laboratory.service;

import com.ruoyi.project.system.laboratory.domain.Laboratory;
import com.ruoyi.project.system.laboratory.mapper.LaboratoryMapper;
import com.ruoyi.project.system.table.domain.SysTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ILaboratoryService")
public class LaboratoryServiceImpl implements ILaboratoryService {
    @Autowired
    LaboratoryMapper mapper;

    @Override
    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    @Override
    public Laboratory selectById(Long laboratoryId) {
        return mapper.selectById(laboratoryId);
    }

    @Override
    public List<Laboratory> selectList() {
        return mapper.selectList();
    }

    @Override
    public Long save(Laboratory laboratory) {
        return mapper.save(laboratory);
    }

    @Override
    public void updateImg(String laboratoryImg, Long laboratoryId) {
        mapper.updateImg(laboratoryImg, laboratoryId);
    }

    @Override
    public Long update(Laboratory laboratory) {
        return mapper.update(laboratory);
    }

    @Override
    public List<Laboratory> findLaboratoryByBuildId(Long id) {
        return mapper.findLaboratoryByBuildId(id);
    }


}
