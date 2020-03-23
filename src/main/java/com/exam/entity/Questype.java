package com.exam.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Questype)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-19 23:55:34
 */
@Data
public class Questype implements Serializable {
    private static final long serialVersionUID = -54597369876168285L;
    /**
    * 试题类型编号
    */
    private Integer questype;
    /**
    * 试题类型名称
    */
    private String quesname;

}