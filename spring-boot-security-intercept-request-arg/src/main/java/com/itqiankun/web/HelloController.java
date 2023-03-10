package com.itqiankun.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
    @PostMapping("/post")
	public void post(@RequestBody JSONObject jsonObject) {
		System.out.println("post请求"+jsonObject.toJSONString());
	}

    @GetMapping("/get")
	public void hello() {
		System.out.println("get请求");
	}

}