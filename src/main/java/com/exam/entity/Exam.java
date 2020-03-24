package com.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Exam)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-24 15:00:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam implements Serializable {
    private static final long serialVersionUID = 522611749059267463L;
    /**
    * 考试编号
    */
    private Integer examid;
    /**
    * 试卷编号
    */
    private Integer paperid;
    /**
    * 课程编号
    */
    private Integer courseid;
    /**
    * 考生学号
    */
    private String stuid;
    /**
    * 年级
    */
    private String grade;
    /**
    * 学期
    */
    private String term;
    /**
    * 专业
    */
    private String major;
    /**
    * 学院
    */
    private String institution;
    /**
    * 考试时长
    */
    private Integer extime;
    /**
    * 考试地点
    */
    private String explace;
    /**
    * 考试日期
    */
    private String exdate;
    /**
    * 考试描述
    */
    private String description;
    /**
    * 是否已考
    */
    private Integer isexam;

    private Paper paper;

    private Course course;

}