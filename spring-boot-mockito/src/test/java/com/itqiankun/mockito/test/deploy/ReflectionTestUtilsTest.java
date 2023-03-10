package com.itqiankun.mockito.test.deploy;

import com.itqiankun.mockito.dao.MyRepository;
import com.itqiankun.mockito.model.Model;
import com.itqiankun.mockito.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 4:12 下午
 */
@RunWith(MockitoJUnitRunner.class)
public class ReflectionTestUtilsTest {

    @Test
    public void testInjectMocks() {
        Model model = new Model(11L, "AAA");
        MyRepository myRepository = mock(MyRepository.class);
        when(myRepository.findById(11L)).thenReturn(model);
        MyService service = new MyService();
        ReflectionTestUtils.setField(service, "myRepository", myRepository);
        System.out.println(service.findById(11L));
    }
}