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
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 4:45 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringMyControllerTest {

    @Mock
    private MyRepository myRepository;

    @InjectMocks
    @Autowired
    private MyService myService;

    @Autowired
    private MyController myController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Model model = new Model(11L, "AAA");
        when(myRepository.findById(11L)).thenReturn(model);
    }


    @Test
    public void findById() throws Exception {
        System.out.println(this.myController.findById(11L));
    }
}