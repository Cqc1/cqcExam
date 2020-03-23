package com.exam.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ShortQues)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@Data
public class ShortQues implements Serializable {
    private static final long serialVersionUID = -74653166490080361L;
    /**
    * 试题编号
    */
    private Integer quesid;
    /**
    * 考试科目
    */
    private Integer courseid;
    /**
    * 问题
    */
    private String question;
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