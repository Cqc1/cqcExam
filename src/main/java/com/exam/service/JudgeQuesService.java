package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.JudgeQues;

import java.util.List;

/**
 * (JudgeQues)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface JudgeQuesService {

    IPage<JudgeQues> findAll(Page<JudgeQues> page);

    JudgeQues findById(Integer quesId);

    List<JudgeQues> findByQues(String question);

    int deleteById(Integer quesId);

    int update(JudgeQues judgeQues);

    int add(JudgeQues judgeQues);

    //随机组卷获取试题
    List<Integer> findByCourse(Integer courseid,String level,Integer quesNum);

    //查询试题详细信息
    List<JudgeQues> findByIdAndType(Integer paperid);

    //多条件随机组卷获取试题
    List<Integer> findByMore(Integer courseid,String level,String chapter,Integer quesNum);

}