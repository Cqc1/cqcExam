package com.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (Institution)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institution implements Serializable {
    private static final long serialVersionUID = 809541561374399416L;
    /**
    * 院系编号
    */
    private Integer institutionid;
    /**
    * 院系名称
    */
    private String instituname;

    private List<Major> majors;


}