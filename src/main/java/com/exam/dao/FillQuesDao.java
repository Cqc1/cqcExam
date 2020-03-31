package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.FillQues;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (FillQues)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface FillQuesDao {
    /**
     * 分页查询所有填空题
     * @param page
     * @return List<FillQues>
     */
    @Select("select * from fill_ques")
    IPage<FillQues> findAll(Page page);

//    @Select("select * from fill_ques where quesId = #{quesid}")
    FillQues findById(Integer quesid);

    @Select("select * from fill_ques where question = #{question}")
    List<FillQues> findByQues(String question);

    @Delete("delete from fill_ques where quesId = #{quesid}")
    int deletebyId(Integer quesid);

    /**
     *更新所有填空题信息
     * @param fillques 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update fill_ques set courseId = #{course.courseid},question = #{question},answer = #{answer}, " +
            "analysis = #{analysis},score = #{score} ,chapter = #{chapter} ,level = #{level} " +
            "where quesId = #{quesid}")
    int updateQue(FillQues fillques);

    @Options(useGeneratedKeys = true,keyProperty = "quesid")
    @Insert("insert into fill_ques(courseId,question,answer,analysis,score,chapter,level) values " +
            "(#{courseid},#{question},#{answer},#{analysis},#{score},#{chapter},#{level})")
    int add(FillQues fillques);
    //随机组卷获取试题
    @Select("select quesId from fill_ques where courseId =#{courseid} and level=#{level} order by rand() desc limit #{quesNum}")
    List<Integer> findByCourse(Integer courseid,String level,Integer quesNum);

    //查询试题详细信息
    @Select("select * from fill_ques where quesId in (select quesId from ques_paper where quesType = 3 and paperId = #{paperid})")
    List<FillQues> findByIdAndType(Integer paperid);
}