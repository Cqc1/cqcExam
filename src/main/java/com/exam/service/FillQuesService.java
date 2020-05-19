package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.FillQues;

import java.util.List;

/**
 * (FillQues)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface FillQuesService {

    IPage<FillQues> findAll(Page<FillQues> page);

    FillQues findById(Integer quesId);

    List<FillQues> findByQues(String question);

    int deleteById(Integer quesId);

    int update(FillQues fillQues);

    int add(FillQues fillQues);

    //随机组卷获取试题
    List<Integer> findByCourse(Integer courseid,String level,Integer quesNum);

    //查询试题详细信息
    List<FillQues> findByIdAndType(Integer paperid);

    //多条件随机组卷获取试题
    List<Integer> findByMore(Integer courseid,String level,String chapter,Integer quesNum);

}