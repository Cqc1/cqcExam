package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.MultQues;

import java.util.List;

/**
 * (MultQues)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface MultQuesService {

    IPage<MultQues> findAll(Page<MultQues> page);

    MultQues findById(Integer quesId);

    List<MultQues> findByQues(String question);

    int deleteById(Integer quesId);

    int update(MultQues multQues);

    int add(MultQues multQues);

    //随机组卷获取试题
    List<Integer> findByCourse(Integer courseid,String level,Integer quesNum);

}