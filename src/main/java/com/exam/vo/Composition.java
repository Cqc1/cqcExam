package com.exam.vo;

import lombok.Data;

//用于持久化组卷时输入的信息
@Data
public class Composition {

    private Integer questype;   //试题类型

    private String quesname;   //试题名称

    private Integer quesnum;    //试题数量


}
