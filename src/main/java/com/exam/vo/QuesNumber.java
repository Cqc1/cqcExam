package com.exam.vo;

import lombok.Data;

//试卷各个题型数量模型
@Data
public class QuesNumber {

    private Integer paperid;

    private String quesname;

    private Integer questypenum;
}
