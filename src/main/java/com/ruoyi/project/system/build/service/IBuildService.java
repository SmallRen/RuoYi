package com.ruoyi.project.system.build.service;

import com.ruoyi.project.system.build.domain.Build;

import java.util.List;

public interface IBuildService {


    List<Build> findAll();

    void save(Build build);

    void delete(Long teachBuildId);

    void update(Build build);

    Build find(Long teachBuildId);

}
