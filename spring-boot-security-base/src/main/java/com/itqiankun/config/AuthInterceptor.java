package com.itqiankun.config;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 拦截器
 * @Author: yhb
 * @Date: Created in 2021/5/7 18:19
 * @Version:1.0
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String remoteAddress = request.getRemoteAddr();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String headerValue = request.getHeader("headerKey");
        System.out.printf("remoteAddress:%s,method:%s,uri:%s,headerValue:%s%n", remoteAddress, method, uri, headerValue);
        return true;
    }

}
