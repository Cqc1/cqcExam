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

    ShortQues findByIdType(Integer quesId,Integer questype);

    ShortQues findById(Integer quesId);

    List<ShortQues> findByQues(String question);

    int deleteById(Integer quesId);

    int update(ShortQues shortQues);

    int add(ShortQues shortQues);

    //随机组卷获取试题
    List<Integer> findByCourse(Integer questype,Integer courseid,String level,Integer quesNum);

    //查询试题详细信息
    List<ShortQues> findByIdAndType(Integer questype,Integer paperid);

    //多条件随机组卷获取试题
    List<Integer> findByMore(Integer questype,Integer courseid,String level,String chapter,Integer quesNum);

    //多条件获取试题总数量
    Integer findNum(Integer questype,Integer courseid,String level);

}