package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.entity.QuesPaper;
import com.exam.vo.QuesNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (QuesPaper)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface QuesPaperDao extends BaseMapper<QuesPaper> {

    /*根据试卷id来查询各种试题的数量*/
    @Select("select ques_paper.paperId as paperid,questype.quesName as quesname,COUNT(ques_paper.quesType) as questypenum " +
            "from ques_paper,questype " +
            "where questype.quesType=ques_paper.quesType and paperId=#{paperid} " +
            "group by paperid,quesname")
    List<QuesNumber> findNumById(Integer paperid);

}