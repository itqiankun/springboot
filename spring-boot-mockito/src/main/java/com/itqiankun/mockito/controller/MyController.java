package com.itqiankun.mockito.controller;

import com.itqiankun.mockito.model.Model;
import com.itqiankun.mockito.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 4:39 下午
 */
@Controller
public class MyController {

    @Autowired
    private MyService myService;

    public void doSomething() {
        this.myService.doSomething();
    }

    public Model findById(Long id) {
        return this.myService.findById(id);
    }
}