package com.ruoyi.project.system.subscribe.service;

import com.ruoyi.project.system.subscribe.domain.Subscribe;

import java.util.List;

public interface ISubscribeService {

    int insert(Subscribe subscribe);
    List<Subscribe> findAll();
}
