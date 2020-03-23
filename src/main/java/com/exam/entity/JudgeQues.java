package com.exam.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (JudgeQues)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@Data
public class JudgeQues implements Serializable {
    private static final long serialVersionUID = 814002750650772725L;
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