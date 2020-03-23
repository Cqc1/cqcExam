package com.exam.vo;

import lombok.Data;

import java.util.List;

//题目模型
@Data
public class Item {

    private Integer courseid;

    private String level;

    private String user;

    private String description;

    private List<Composition> composition;
}
