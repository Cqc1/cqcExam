package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ShortQues;

import java.util.List;

/**
 * (ShortQues)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
public interface ShortQuesService {

    IPage<ShortQues> findAll(Page<ShortQues> page);

    ShortQues findByIdType(Integer quesId,String questype);

    ShortQues findById(Integer quesId);

    List<ShortQues> findByQues(String question);

    int deleteById(Integer quesId);

    int update(ShortQues shortQues);

    int add(ShortQues shortQues);

}