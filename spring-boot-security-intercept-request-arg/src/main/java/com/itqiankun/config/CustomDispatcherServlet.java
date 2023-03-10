package com.itqiankun.config;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: ma_qiankun
 * @date: 2023/3/8
 **/
public class CustomDispatcherServlet extends DispatcherServlet {

    /**
     * 包装成我们自定义的request
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doDispatch(new CustomHttpServletRequestWrapper(request), response);
    }
}
