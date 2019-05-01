package com.ruoyi.project.system.build.mapper;

import com.ruoyi.project.system.build.domain.Build;

import java.util.List;

public interface BuildMapper {

    List<Build> findAll();

    void save(Build build);

    void delete(Long teachBuildId);

    void update(Build build);

    Build find(Long teachBuildId);
}
