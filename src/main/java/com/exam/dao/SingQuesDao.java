package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.SingQues;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (SingQues)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface SingQuesDao {

    /**
     * 分页查询所有单选题
     * @param page
     * @return List<SingQues>
     */
    @Select("select * from sing_ques")
    IPage<SingQues> findAll(Page page);

//    @Select("select * from sing_ques where quesId = #{quesid}")
    SingQues findById(Integer quesid);

    @Select("select * from sing_ques where question = #{question}")
    List<SingQues> findByQues(String question);

    @Delete("delete from sing_ques where quesId = #{quesid}")
    int deletebyId(Integer quesid);

    /**
     *更新所有单选题信息
     * @param singques 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update sing_ques set courseId = #{course.courseid},question = #{question},answer = #{answer}, " +
            "optionA = #{optiona},optionB = #{optionb} ,optionC = #{optionc} ,optionD = #{optiond} ," +
            "analysis = #{analysis},score = #{score} ,chapter = #{chapter} ,level = #{level} " +
            "where quesId = #{quesid}")
    int updateQue(SingQues singques);

    @Options(useGeneratedKeys = true,keyProperty = "quesid")
    @Insert("insert into sing_ques(courseId,question,optionA,optionB,optionC,optionD,answer,analysis,score,chapter,level) values " +
            "(#{courseid},#{question},#{optiona},#{optionb},#{optionc},#{optiond},#{answer},#{analysis},#{score},#{chapter},#{level})")
    int add(SingQues singques);

    //随机组卷获取试题
    @Select("select quesId from sing_ques where courseId =#{courseid} and level=#{level} order by rand() desc limit #{quesNum}")
    List<Integer> findByCourse(Integer courseid,String level,Integer quesNum);

    //查询试题详细信息
    @Select("select * from sing_ques where quesId in (select quesId from paper where quesType = 1 and paperId = #{paperid})")
    List<SingQues> findByIdAndType(Integer paperid);
}