package com.exam.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SingQues)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@Data
public class SingQues implements Serializable {
    private static final long serialVersionUID = 826172709213923219L;
    /**
    * 试题编号
    */
    private Integer quesid;
    /**
    * 课程编号
    */
    private Integer courseid;
    /**
    * 问题
    */
    private String question;
    /**
    * 选项A
    */
    private String optiona;
    /**
    * 选项B
    */
    private String optionb;
    /**
    * 选项C
    */
    private String optionc;
    /**
    * 选项D
    */
    private String optiond;
    /**
    * 参考答案
    */
    private String answer;
    /**
    * 答案解析
    */
    private String analysis;
    /**
    * 分值
    */
    private Integer score;
    /**
    * 所属章节
    */
    private String chapter;
    /**
    * 难度等级
    */
    private String level;
    /**
    * 试题类型
    */
    private String questype;

    private Course course;

    private Questype type;
}