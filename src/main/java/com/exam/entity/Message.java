package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 留言表(Message)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Message implements Serializable {

    private static final long serialVersionUID = 847821963800708552L;
    /**
    * 留言编号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer id;
    /**
    * 标题
    */
    private String title;
    /**
    * 留言内容
    */
    private String content;
    /**
    * 留言时间
    */
    private Object time;



}