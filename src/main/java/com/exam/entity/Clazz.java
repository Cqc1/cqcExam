package com.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Clazz)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz implements Serializable {
    private static final long serialVersionUID = 375873295323830077L;
    /**
    * 班级编号
    */
    private Integer clazzid;
    /**
    * 班级名称
    */
    private String calname;
    /**
    * 专业编号
    */
    private Integer majorid;

    private Major major; //专业实体

}