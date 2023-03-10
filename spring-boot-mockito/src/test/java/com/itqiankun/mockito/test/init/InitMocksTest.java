package com.itqiankun.mockito.test.init;

import com.itqiankun.mockito.dao.MyRepository;
import com.itqiankun.mockito.model.Model;
import com.itqiankun.mockito.service.MyService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.when;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 3:05 下午
 */
public class InitMocksTest {

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    private MyRepository myRepository;

    @InjectMocks
    private MyService myService;

    @Test
    public void testInjectMocks() {
        Model model = new Model(11L, "AAA");
        when(myRepository.findById(11L)).thenReturn(model);
        System.out.println(myService.findById(11L));
    }
}