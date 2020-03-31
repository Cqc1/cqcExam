package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ShortQues;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (ShortQues)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface ShortQuesDao {

    /**
     * 分页查询所有简答题等多种非客观题
     * @param page
     * @return List<ShortQues>
     */
    @Select("select * from short_ques")
    IPage<ShortQues> findAll(Page page);

    //按照类型和试题编号查询
//    @Select("select * from short_ques where quesId = #{quesid} and questype=#{questype}")
    ShortQues findByIdType(Integer quesid,String questype);

    @Select("select * from short_ques where quesId = #{quesid}")
    ShortQues findById(Integer quesid);

    @Select("select * from short_ques where question = #{question}")
    List<ShortQues> findByQues(String question);

    @Delete("delete from short_ques where quesId = #{quesid}")
    int deletebyId(Integer quesid);

    /**
     *更新所有简答题等多种非客观题信息
     * @param shortQues 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update short_ques set courseId = #{course.courseid},question = #{question},answer = #{answer} ," +
            "analysis = #{analysis},score = #{score} ,chapter = #{chapter} ,level = #{level},quesType=#{type.questype} " +
            "where quesId = #{quesid}")
    int updateQue(ShortQues shortQues);

    @Options(useGeneratedKeys = true,keyProperty = "quesid")
    @Insert("insert into short_ques(courseId,question,answer,analysis,score,chapter,level,quesType) values " +
            "(#{courseid},#{question},#{answer},#{analysis},#{score},#{chapter},#{level},#{questype})")
    int add(ShortQues shortQues);

    //随机组卷获取试题
    @Select("select quesId from short_ques where quesType=#{questype} and courseId =#{courseid} and level=#{level} order by rand() desc limit #{quesNum}")
    List<Integer> findByCourse(Integer questype,Integer courseid,String level,Integer quesNum);

    //查询试题详细信息
    @Select("select * from short_ques where quesId in (select quesId from ques_paper where quesType = #{questype} and paperId = #{paperid})")
    List<ShortQues> findByIdAndType(Integer questype,Integer paperid);
}