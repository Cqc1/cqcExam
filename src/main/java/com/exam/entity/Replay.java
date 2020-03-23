package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 回复表(Replay)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Replay implements Serializable {

    private static final long serialVersionUID = 343908905333139211L;
    /**
    * 留言编号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer messageid;
    /**
    * 回复编号
    */
    private Integer replayid;
    /**
    * 内容
    */
    private String replay;
    /**
    * 回复时间
    */
    private Object replaytime;


}