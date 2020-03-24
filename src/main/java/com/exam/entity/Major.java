package com.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Major)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Major implements Serializable {
    private static final long serialVersionUID = -37943108635836852L;
    /**
    * 专业编号
    */
    private Integer majorid;
    /**
    * 专业名称
    */
    private String major;
    /**
    * 院系编号
    */
    private Integer institutionid;

    private Institution institution;//院系实体

}