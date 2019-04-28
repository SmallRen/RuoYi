package com.ruoyi.project.system.teachbuild.service;

import com.ruoyi.project.system.teachbuild.domain.TeachBuild;

import java.util.List;

public interface ITeachBuildService {
    List<TeachBuild> findAll();

    TeachBuild find(Long id);
}
