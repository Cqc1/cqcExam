package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.JudgeQues;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (JudgeQues)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface JudgeQuesDao {

    /**
     * 分页查询所有判断题
     * @param page
     * @return List<JudgeQues>
     */
    @Select("select * from judge_ques")
    IPage<JudgeQues> findAll(Page page);

//    @Select("select * from judge_ques where quesId = #{quesid}")
    JudgeQues findById(Integer quesid);

    @Select("select * from judge_ques where question = #{question}")
    List<JudgeQues> findByQues(String question);

    @Delete("delete from judge_ques where quesId = #{quesid}")
    int deletebyId(Integer quesid);

    /**
     *更新所有判断题信息
     * @param judgeQues 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update judge_ques set courseId = #{course.courseid},question = #{question},answer = #{answer}, " +
            "analysis = #{analysis},score = #{score} ,chapter = #{chapter} ,level = #{level} " +
            "where quesId = #{quesid}")
    int updateQue(JudgeQues judgeQues);

    @Options(useGeneratedKeys = true,keyProperty = "quesid")
    @Insert("insert into judge_ques(courseId,question,answer,analysis,score,chapter,level) values " +
            "(#{courseid},#{question},#{answer},#{analysis},#{score},#{chapter},#{level})")
    int add(JudgeQues judgeQues);

    //随机组卷获取试题
    @Select("select quesId from judge_ques where courseId =#{courseid} and level=#{level} order by rand() desc limit #{quesNum}")
    List<Integer> findByCourse(Integer courseid,String level,Integer quesNum);

    //查询试题详细信息
    @Select("select * from judge_ques where quesId in (select quesId from ques_paper where quesType = 4 and paperId = #{paperid})")
    List<JudgeQues> findByIdAndType(Integer paperid);

    //多条件随机组卷获取试题
    /*@Select("select quesId from judge_ques where courseId =#{courseid} and level=#{level} and chapter=#{chapter} order by rand() desc limit #{quesNum}")*/
    List<Integer> findByMore(Integer courseid,String level,String chapter,Integer quesNum);

    //多条件获取试题总数量
    /*@Select("select COUNT(quesId) as num from judge_ques where courseId =#{courseid} and level=#{level} ")*/
    Integer findNum(Integer courseid,String level);

}