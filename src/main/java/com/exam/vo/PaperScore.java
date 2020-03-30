package com.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//试卷各个题型的总分值以及总分模型
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaperScore {

    private Integer paperid;    //试卷id

    private Integer questype;   //该试题类型

    private String quesname;   //该题型名称

    private Integer quesnum;   //该题型数量

    private Integer typescore;  //该试题总分值





}
