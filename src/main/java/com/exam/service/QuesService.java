package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.vo.QuesVO;

import java.util.List;

public interface QuesService {

    IPage<QuesVO> findAll(Page<QuesVO> page); //分页查询所有

    List<QuesVO> findByQues(String question,String questype); //按照试题类型和试题题目查询

    List<QuesVO> findByType(String questype);//按照试题类型进行查询

    //按题目所属科目进行查询
    List<QuesVO> findByCourse(Integer courseid);
}
