package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Institution;
import com.exam.service.InstitutionService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Institution)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@RestController
@RequestMapping("institution")
public class InstitutionController {
    /**
     * 服务对象
     */
    @Resource
    private InstitutionService institutionService;

    @GetMapping("/findAll/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Institution> institutionPage = new Page<>(page,size);
        IPage<Institution> res = institutionService.findAll(institutionPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有院系",res);
    }

    //不分页查询
    @GetMapping("/selectAll")
    public ApiResult selectAll() {
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200, "请求成功！", institutionService.selectAll());
        return apiResult;
    }
    /**
     * 通过主键查询单条数据
     *
     * @param institutionid 主键
     * @return 单条数据
     */
    @GetMapping("/select/{institutionid}")
    public ApiResult findById(@PathVariable("institutionid") Integer institutionid) {
        Institution res = institutionService.queryById(institutionid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的院系不存在",null);
        }
    }
    //批量删除所有选中的院系
    @DeleteMapping("/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            institutionService.deleteById(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @DeleteMapping("/delete/{institutionid}")
    public ApiResult deletebyId(@PathVariable("institutionid") Integer institutionid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",institutionService.deleteById(institutionid));
    }

    @PutMapping("/update")
    public ApiResult updateInstitu(@RequestBody Institution institution) {
        Institution res = institutionService.update(institution);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/add")
    public ApiResult add(@RequestBody Institution institution) {
        Institution res = institutionService.insert(institution);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }


}