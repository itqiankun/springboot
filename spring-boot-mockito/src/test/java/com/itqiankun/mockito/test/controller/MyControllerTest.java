package com.itqiankun.mockito.test.controller;

import com.itqiankun.mockito.controller.MyController;
import com.itqiankun.mockito.dao.MyRepository;
import com.itqiankun.mockito.model.Model;
import com.itqiankun.mockito.service.MyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 4:41 下午
 */
@RunWith(MockitoJUnitRunner.class)
public class MyControllerTest {

    @Mock
    private MyRepository myRepository;

    @InjectMocks
    private MyService myService;

    @InjectMocks
    private MyController myController;

    @Before
    public void setUp() throws Exception {
        Model model = new Model(11L, "AAA");
        doNothing().when(myRepository).doSomething();
        when(myRepository.findById(11L)).thenReturn(model);
    }


    @Test
    public void findById() throws Exception {
        System.out.println(this.myController.findById(11L));
    }
}