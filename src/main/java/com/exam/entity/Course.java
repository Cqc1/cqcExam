package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Course implements Serializable {


    private static final long serialVersionUID = 795092503245669704L;
    /**
    * 课程编号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer courseid;
    
    private String couname;
    /**
    * 课时
    */
    private Integer couperiod;
    /**
    * 学分
    */
    private Integer credit;

    private Integer institutionid;  //院系编号

    private Institution institution;//院系实体


}