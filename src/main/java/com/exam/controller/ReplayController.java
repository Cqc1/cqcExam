package com.exam.controller;

import com.exam.entity.Replay;
import com.exam.service.ReplayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 回复表(Replay)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
@RequestMapping("replay")
public class ReplayController {
    /**
     * 服务对象
     */
    @Resource
    private ReplayService replayService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Replay selectOne(Integer id) {
        return this.replayService.queryById(id);
    }

}