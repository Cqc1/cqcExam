package com.exam.controller;

import com.exam.entity.Admin;
import com.exam.entity.ApiResult;
import com.exam.service.AdminService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:26
 */
@RestController
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/admin/{id}")
    public Admin selectOne(@PathVariable("id") Integer id) {
        return this.adminService.queryById(id);
    }

    @PutMapping("/adminPWD")
    public ApiResult updatePwd(@RequestBody Admin admin) {
        adminService.updatePwd(admin);
        return ApiResultHandler.buildApiResult(200,"密码更新成功",null);
    }

}