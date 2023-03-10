package com.itqiankun.mockito.model;

import lombok.Data;

/**
 * @Author: ma_qiankun
 * @Date: 2021/11/19 3:03 下午
 */
@Data
public class Model {
    private Long id;
    private  String real_repository;
    public Model(Long id, String real_repository) {
        this.id =id;
        this .real_repository =real_repository;
    }
}