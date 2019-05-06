package com.ruoyi.project.system.subscribe.service;

import com.ruoyi.project.system.subscribe.domain.Subscribe;
import com.ruoyi.project.system.subscribe.mapper.SubscribeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeServiceImpl implements ISubscribeService {
    @Autowired
    SubscribeMapper subscribeMapper;

    @Override
    public int insert(Subscribe subscribe) {
        return subscribeMapper.insert(subscribe);
    }

    @Override
    public List<Subscribe> findAll() {
        return subscribeMapper.findAll();
    }

    @Override
    public List<Subscribe> findByTableId(Long tableId) {
        return subscribeMapper.findByTableId(tableId);
    }


}
