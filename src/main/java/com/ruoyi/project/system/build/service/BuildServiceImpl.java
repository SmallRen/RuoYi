package com.ruoyi.project.system.build.service;

import com.ruoyi.project.system.build.domain.Build;
import com.ruoyi.project.system.build.mapper.BuildMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildServiceImpl implements IBuildService {
    @Autowired
    BuildMapper mapper;

    @Override
    public List<Build> findAll() {
        return mapper.findAll();
    }

    @Override
    public void save(Build build) {
        mapper.save(build);
    }

    @Override
    public void delete(Long teachBuildId) {
        mapper.delete(teachBuildId);
    }

    @Override
    public void update(Build build) {
        mapper.update(build);
    }

    @Override
    public Build find(Long teachBuildId) {
        return mapper.find(teachBuildId);
    }
}
