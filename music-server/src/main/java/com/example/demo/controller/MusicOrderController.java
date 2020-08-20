package com.example.demo.controller;

import com.example.demo.service.MusicOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music/order")
public class MusicOrderController {

    @Autowired
    private MusicOrderService musicOrderService;

    @GetMapping("/list")
    public Object list() {
        return musicOrderService.list();
    }
}
