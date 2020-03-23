package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.exam.vo.PaperScore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * (QuesPaper)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer questype;
    /**
    * 试题编号
    */
    private Integer quesid;


    //用于查询试卷的题型的总分
    private List<PaperScore> paperScores;

    public QuesPaper(Integer paperid, Integer questype, Integer quesid) {
        this.paperid=paperid;
        this.questype=questype;
        this.quesid=quesid;
    }




}