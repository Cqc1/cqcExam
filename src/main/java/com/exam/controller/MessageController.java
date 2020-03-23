package com.exam.controller;

import com.exam.entity.Message;
import com.exam.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 留言表(Message)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
@RequestMapping("message")
public class MessageController {
    /**
     * 服务对象
     */
    @Resource
    private MessageService messageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Message selectOne(Integer id) {
        return this.messageService.queryById(id);
    }

}