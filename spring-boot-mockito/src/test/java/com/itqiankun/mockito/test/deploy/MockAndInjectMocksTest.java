package com.itqiankun.mockito.test.deploy;

import com.itqiankun.mockito.dao.MyRepository;
import com.itqiankun.mockito.model.Model;
import com.itqiankun.mockito.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 3:05 下午
 */
@RunWith(MockitoJUnitRunner.class)
public class MockAndInjectMocksTest {

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