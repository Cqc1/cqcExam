package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (QuesPaper)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class QuesPaper implements Serializable {

    private static final long serialVersionUID = -57635866738201355L;
    /**
    * 试卷编号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer paperid;
    /**
    * 试题类型
    */
    private String questype;
    /**
    * 试题编号
    */
    private Integer quesid;


}