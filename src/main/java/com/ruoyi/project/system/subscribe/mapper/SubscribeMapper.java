package com.ruoyi.project.system.subscribe.mapper;

import com.ruoyi.project.system.subscribe.domain.Subscribe;

import java.util.List;

public interface SubscribeMapper {
    int insert(Subscribe subscribe);
    List<Subscribe> findAll();

    List<Subscribe> findByTableId(Long tableId);
}
