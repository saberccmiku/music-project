package com.example.demo.dao;

import com.example.demo.domain.MusicOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicOrderMapper {

    List<MusicOrder> list();
    MusicOrder detail(String id);
}
