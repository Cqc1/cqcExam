package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Major;
import com.exam.service.MajorService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Majors)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@RestController
@RequestMapping("major")
public class MajorController {
    /**
     * 服务对象
     */
    @Resource
    private MajorService majorService;
    @GetMapping("/findAll/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Major> majorPage = new Page<>(page,size);
        IPage<Major> res = majorService.findAll(majorPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有专业",res);
    }

    //不分页查询
    @GetMapping("/selectAll")
    public ApiResult selectAll() {
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200, "请求成功！", majorService.selectAll());
        return apiResult;
    }
    /**
     * 通过主键查询单条数据
     *
     * @param majorid 主键
     * @return 单条数据
     */
    @GetMapping("/select/{majorid}")
    public ApiResult findById(@PathVariable("majorid") Integer majorid) {
        Major res = majorService.queryById(majorid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的专业不存在",null);
        }
    }
    //通过院系id来查找
    @GetMapping("/selectInstitu/{institutionid}")
    public ApiResult findByInstituId(@PathVariable("institutionid") Integer institutionid) {
        List<Major> res = majorService.queryByInstituId(institutionid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的专业不存在",null);
        }
    }
    //批量删除所有选中的专业
    @DeleteMapping("/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            majorService.deleteById(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @DeleteMapping("/delete/{majorid}")
    public ApiResult deletebyId(@PathVariable("majorid") Integer majorid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",majorService.deleteById(majorid));
    }

    @PutMapping("/update")
    public ApiResult updateMajor(@RequestBody Major major) {
        Major res = majorService.update(major);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/add")
    public ApiResult add(@RequestBody Major major) {
        Major res = majorService.insert(major);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }


}