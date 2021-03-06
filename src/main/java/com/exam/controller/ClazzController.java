package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Clazz;
import com.exam.service.ClazzService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Clazz)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@RestController
@RequestMapping("clazz")
public class ClazzController {
    /**
     * 服务对象
     */
    @Resource
    private ClazzService clazzService;

    @GetMapping("/findAll/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Clazz> clazzPage = new Page<>(page,size);
        IPage<Clazz> res = clazzService.findAll(clazzPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有班级",res);
    }

    //不分页查询
    @GetMapping("selectAll")
    public ApiResult selectAll() {
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200, "请求成功！", clazzService.selectAll());
        return apiResult;
    }
    /**
     * 通过主键查询单条数据
     *
     * @param clazzid 主键
     * @return 单条数据
     */
    @GetMapping("/select/{clazzid}")
    public ApiResult findById(@PathVariable("clazzid") Integer clazzid) {
        Clazz res = clazzService.queryById(clazzid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的班级不存在",null);
        }
    }
    @GetMapping("/selectByMajor/{majorid}")
    public ApiResult findByMajorId(@PathVariable("majorid") Integer majorid) {
        List<Clazz> res = clazzService.queryByMajorId(majorid);
        if (!res.isEmpty()) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的班级不存在",null);
        }
    }
    //批量删除所有选中的班级
    @DeleteMapping("/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            clazzService.deleteById(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @DeleteMapping("/delete/{clazzid}")
    public ApiResult deletebyId(@PathVariable("clazzid") Integer clazzid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",clazzService.deleteById(clazzid));
    }

    @PutMapping("/update")
    public ApiResult updateClazz(@RequestBody Clazz clazz) {
        Clazz res = clazzService.update(clazz);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/add")
    public ApiResult add(@RequestBody Clazz clazz) {
        Clazz res = clazzService.insert(clazz);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }

}