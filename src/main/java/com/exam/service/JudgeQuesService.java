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

}