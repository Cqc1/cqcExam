package com.exam.controller;

import com.exam.entity.Score;
import com.exam.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Score)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
@RequestMapping("score")
public class ScoreController {
    /**
     * 服务对象
     */
    @Resource
    private ScoreService scoreService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Score selectOne(Integer id) {
        return this.scoreService.queryById(id);
    }

}