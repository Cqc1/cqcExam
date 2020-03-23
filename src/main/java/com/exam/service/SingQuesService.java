package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.SingQues;

import java.util.List;

/**
 * (SingQues)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface SingQuesService {

    IPage<SingQues> findAll(Page<SingQues> page);

    SingQues findById(Integer quesId);

    List<SingQues> findByQues(String question);

    int deleteById(Integer quesId);

    int update(SingQues singQues);

    int add(SingQues singQues);

}