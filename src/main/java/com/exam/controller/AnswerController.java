package com.exam.controller;

import com.exam.entity.Answer;
import com.exam.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Answer)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
@RequestMapping("answer")
public class AnswerController {
    /**
     * 服务对象
     */
    @Resource
    private AnswerService answerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Answer selectOne(Integer id) {
        return this.answerService.queryById(id);
    }

}