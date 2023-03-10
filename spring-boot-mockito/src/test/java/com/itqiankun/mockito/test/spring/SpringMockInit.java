package com.itqiankun.mockito.test.spring;

import com.itqiankun.mockito.dao.MyRepository;
import com.itqiankun.mockito.model.Model;
import com.itqiankun.mockito.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 4:52 下午
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMockInit {

    @Mock
    private MyRepository myRepository;

    @Autowired
    @InjectMocks
    private MyService myService;

    @Test
    public void testInjectMocks() {
        Model model = new Model(11L, "AAA");
        when(myRepository.findById(11L)).thenReturn(model);
        System.out.println(myService.findById(11L));
    }
}