package com.exam.controller;

import com.exam.entity.Exam;
import com.exam.service.ExamService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Exam)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
@RequestMapping("exam")
public class ExamController {
    /**
     * 服务对象
     */
    @Resource
    private ExamService examService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Exam selectOne(Integer id) {
        return this.examService.queryById(id);
    }

}