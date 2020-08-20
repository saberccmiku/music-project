package com.example.demo.service;

import com.example.demo.domain.MusicOrder;

import java.util.List;

public interface MusicOrderService {

    List<MusicOrder> list();
    MusicOrder detail(String id);

}
