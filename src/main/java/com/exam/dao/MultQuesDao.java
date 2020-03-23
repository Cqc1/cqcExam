package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.MultQues;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (MultQues)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface MultQuesDao {

    /**
     * 分页查询所有多选题
     * @param page
     * @return List<MultQues>
     */
    @Select("select * from mult_ques")
    IPage<MultQues> findAll(Page page);

//    @Select("select * from mult_ques where quesId = #{quesid}")
    MultQues findById(Integer quesid);

    @Select("select * from mult_ques where question = #{question}")
    List<MultQues> findByQues(String question);

    @Delete("delete from mult_ques where quesId = #{quesid}")
    int deletebyId(Integer quesid);

    /**
     *更新所有多选题信息
     * @param multques 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update mult_ques set courseId = #{course.courseid},question = #{question},answer = #{answer}, " +
            "optionA = #{optiona},optionB = #{optionb} ,optionC = #{optionc} ,optionD = #{optiond} ," +
            "analysis = #{analysis},score = #{score} ,chapter = #{chapter} ,level = #{level} " +
            "where quesId = #{quesid}")
    int updateQue(MultQues multques);

    @Options(useGeneratedKeys = true,keyProperty = "quesid")
    @Insert("insert into mult_ques(courseId,question,optionA,optionB,optionC,optionD,answer,analysis,score,chapter,level) values " +
            "(#{courseid},#{question},#{optiona},#{optionb},#{optionc},#{optiond},#{answer},#{analysis},#{score},#{chapter},#{level})")
    int add(MultQues multques);

    //随机组卷获取试题
    @Select("select quesId from mult_ques where courseId =#{courseid} and level=#{level} order by rand() desc limit #{quesNum}")
    List<Integer> findByCourse(Integer courseid,String level,Integer quesNum);

}