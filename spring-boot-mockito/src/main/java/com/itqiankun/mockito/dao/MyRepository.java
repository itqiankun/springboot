package com.itqiankun.mockito.dao;

import com.itqiankun.mockito.model.Model;
import org.springframework.stereotype.Repository;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 3:02 下午
 */
@Repository
public class MyRepository {

    public void doSomething() {
        System.out.println("here's dosomething");
    }

    public Model findById(Long id) {
        return new Model(id, "Real Repository");
    }
}
