package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Questype;
import com.exam.service.QuestypeService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Questype)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-19 23:55:34
 */
@RestController
public class QuestypeController {
    /**
     * 服务对象
     */
    @Resource
    private QuestypeService questypeService;
    //分页查询
    @GetMapping("/questypes/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Questype> questypePage = new Page<>(page,size);
        IPage<Questype> res =  questypeService.findAll(questypePage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有试题类型信息",res);
    }
    //不分页查询
    @GetMapping("/questypeInfo")
    public ApiResult findAll() {
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200, "请求成功！", questypeService.findAll());
        return apiResult;
    }
    //按照试题类型编号查询
    @GetMapping("/questypeEdit/{questype}")
    public ApiResult findById(@PathVariable("questype") Integer questype) {
        Questype res = questypeService.findById(questype);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试题类型不存在",null);
        }
    }
    //按试题类型名查找
    @GetMapping("/questype/{quesName}")
    public ApiResult findByName(@PathVariable("quesName") String quesName) {
        List<Questype> res = (List<Questype>) questypeService.findByName(quesName);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试题类型不存在",null);
        }
    }

    //批量删除所有选中的试题类型
    @DeleteMapping("/questype/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            questypeService.deleteById(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @DeleteMapping("/questypeDel/{questype}")
    public ApiResult deletebyId(@PathVariable("questype") Integer questype) {
        return ApiResultHandler.buildApiResult(200,"删除成功",questypeService.deleteById(questype));
    }

    @PutMapping("/questypeUpdate")
    public ApiResult updateStu(@RequestBody Questype questype) {
        int res = questypeService.update(questype);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/questypeAdd")
    public ApiResult add(@RequestBody Questype questype) {
        int res = questypeService.add(questype);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }

}