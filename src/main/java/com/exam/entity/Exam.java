package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Exam)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Exam implements Serializable {


    private static final long serialVersionUID = 143135214507080463L;
    /**
    * 考试编号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer examid;
    /**
    * 试卷编号
    */
    private Integer paperid;
    /**
    * 课程名称
    */
    private String course;
    /**
    * 考生学号
    */
    private Integer stuid;
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
    private String isexam;


}