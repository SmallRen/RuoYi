package com.ruoyi.project.system.teachbuild.service;

import com.ruoyi.project.system.teachbuild.mapper.TeachBuildMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeachBuildServiceImpl implements ITeachBuildService {
    @Autowired
    TeachBuildMapper mapper;
}
