package com.itqiankun.mockito.service;

import com.itqiankun.mockito.dao.MyRepository;
import com.itqiankun.mockito.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 3:03 下午
 */
@Service
public class MyService {

    @Autowired
    private MyRepository myRepository;

    public void doSomething() {
        this.myRepository.doSomething();
    }

    public Model findById(Long id) {
        return this.myRepository.findById(id);
    }
}