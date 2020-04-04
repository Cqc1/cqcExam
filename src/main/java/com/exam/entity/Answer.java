package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Answer)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Answer implements Serializable {

    private static final long serialVersionUID = 499814263818754850L;

    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer answerid;
    
    private Integer examid;
    
    private Integer stuid;
    /**
    * 试题类型
    */
    private Integer questype;
    /**
    * 试题编号
    */
    private Integer quesid;
    /**
    * 考生答案
    */
    private String answer;

    private String rightAnswer;

    private Integer score;

    private Questype ques;


}