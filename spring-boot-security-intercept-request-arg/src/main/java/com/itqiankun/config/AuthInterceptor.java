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
        //获取get请求参数
        String queryString = request.getQueryString();
        //获取post请求参数
        byte[] bodyBytes;
        String body = null;
        try {
            // post请求体只有小于10kb的才会打印入参
            int contentLength = request.getContentLength();
            if(contentLength == -1 || contentLength == 0){
                contentLength = 100 * 1024;
            }
            if(contentLength <= 10 * 1024){
                bodyBytes = StreamUtils.copyToByteArray(request.getInputStream());
                body = new String(bodyBytes, request.getCharacterEncoding());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("remoteAddress:%s,method:%s,uri:%s,headerValue:%s,getRequestParam:%s,postRequestParam:%s%n", remoteAddress, method, uri, headerValue, queryString, body);
        return true;
    }

}
