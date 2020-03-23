package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.entity.QuesPaper;
import com.exam.vo.QuesNumber;
import org.apache.ibatis.annotations.Insert;
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

    @Select("select paperId, questionType,questionId from ques_paper")
    List<QuesPaper> findAll();

    /*根据试卷id来查询各种试题的数量*/
    @Select("select ques_paper.paperId as paperid,questype.quesName as quesname,COUNT(ques_paper.quesType) as questypenum " +
            "from ques_paper,questype " +
            "where questype.quesType=ques_paper.quesType and paperId=#{paperid} " +
            "group by paperid,quesname")
    List<QuesNumber> findNumById(Integer paperid);

    @Insert("insert into ques_paper(paperId,quesType,quesId) values " +
            "(#{paperid},#{questype},#{quesid})")
    int add(QuesPaper quesPaper);

    //通过paperid来查询该试卷的各种题型的分值

    QuesPaper findScoreById(Integer paperid);

}