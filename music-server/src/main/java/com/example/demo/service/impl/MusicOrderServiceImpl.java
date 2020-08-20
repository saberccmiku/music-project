package com.example.demo.service.impl;

import com.example.demo.dao.MusicOrderMapper;
import com.example.demo.domain.MusicOrder;
import com.example.demo.service.MusicOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicOrderServiceImpl implements MusicOrderService {

    @Autowired
    private MusicOrderMapper musicOrderMapper;

    @Override
    public List<MusicOrder> list() {
        return musicOrderMapper.list();
    }

    @Override
    public MusicOrder detail(String id) {
        return musicOrderMapper.detail(id);
    }
}
