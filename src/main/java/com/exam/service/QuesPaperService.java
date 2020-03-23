package com.exam.service;

import com.exam.vo.QuesNumber;

import java.util.List;

/**
 * (QuesPaper)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
public interface QuesPaperService {

    /*根据试卷id来查询各种试题的数量*/
    List<QuesNumber> findNumById(Integer paperid);

}