package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.exam.vo.Item;
import com.exam.vo.QuesNumber;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Paper)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Paper implements Serializable {

    private static final long serialVersionUID = -26609821571391966L;
    /**
    * 试卷编号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer paperid;
    /**
    * 课程编号
    */
    private Integer courseid;
    /**
    * 总分
    */
    private Integer totalscore;
    /**
    * 组卷人
    */
    private String user;
    /**
    * 试卷描述
    */
    private String description;

    private List<Item> itemList;

    private Course course;

    private  List<QuesNumber> quesNumberList; //用于统计该试卷的各种题型的数量
}