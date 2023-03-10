package com.itqiankun.config;

import com.obs.services.ObsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ma_qiankun
 * @Date: 2021/10/20 9:25 上午
 */

@Configuration
public class ObsConfig {

    @Value("${huawei.obs.ak}")
    private String ak;

    @Value("${huawei.obs.sk}")
    private String sk;

    @Value("${huawei.obs.upload.endPoint}")
    private String endPoint;

    @Bean
    public ObsClient getObsClient(){
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        return obsClient;
    }
}