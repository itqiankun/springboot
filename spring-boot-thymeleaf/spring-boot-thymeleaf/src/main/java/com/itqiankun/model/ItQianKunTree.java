package com.itqiankun.model;

import lombok.Data;
import java.util.List;

@Data
public class ItQianKunTree {
    private Integer id;
    private String name;
    private Integer parentId;

    public ItQianKunTree(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    private List<ItQianKunTree> children;
}
