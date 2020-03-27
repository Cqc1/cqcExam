package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Score)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Score implements Serializable {

    private static final long serialVersionUID = 710358777382570705L;
    /**
    * 分数编号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer scoreid;
    /**
    * 考试编号
    */
    private Integer examid;
    /**
    * 学号
    */
    private Integer stuid;
    /**
    * 课程名称
    */
    private String course;
    /**
    * 客观成绩
    */
    private Integer objscore;
    /**
    * 主观成绩
    */
    private Integer subscore;
    /**
    * 总成绩
    */

    private Integer totalscore;

    private String claname;   //班级名称

    private String major;//专业名称

    private String instituname;//院系名称

    private String grade;   //年级

    private String term ;//学期

    private String description;//试卷描述

    private Student student;//学生实体


}