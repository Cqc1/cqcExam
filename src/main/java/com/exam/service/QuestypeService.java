package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Questype;

import java.util.List;

/**
 * (Questype)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-19 23:55:34
 */
public interface QuestypeService {

    IPage<Questype> findAll(Page<Questype> page);

    List<Questype> findAll();

    Questype findById(Integer questype);

    List<Questype> findByName(String quesName);

    int deleteById(Integer questype);

    int update(Questype questype);

    int add(Questype questype);
}