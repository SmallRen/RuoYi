package com.ruoyi.project.system.teachbuild.service;

import com.ruoyi.project.system.teachbuild.domain.TeachBuild;
import com.ruoyi.project.system.teachbuild.mapper.TeachBuildMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachBuildServiceImpl implements ITeachBuildService {
    @Autowired
    TeachBuildMapper mapper;

    @Override
    public List<TeachBuild> findAll() {
        return mapper.finAll();
    }

    @Override
    public TeachBuild find(Long id) {
        return mapper.find(id);
    }
}
