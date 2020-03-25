package com.exam.controller;

import com.exam.entity.Exam;
import com.exam.service.ExamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Exam)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-24 15:00:28
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
     * @param examid 主键
     * @return 单条数据
     */
    @GetMapping("selectById/{examid}")
    public Exam selectById(@PathVariable("examid")Integer examid) {
        return this.examService.queryById(examid);
    }

    @GetMapping("selectByMajorId/{majorid}")
    public List<Exam> selectByMajorId(@PathVariable("majorid")Integer majorid) {
        return this.examService.querByMajorId(majorid);
    }

}