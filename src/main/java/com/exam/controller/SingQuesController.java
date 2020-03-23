package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.SingQues;
import com.exam.service.SingQuesService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SingQues)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@RestController
public class SingQuesController {
    /**
     * 服务对象
     */
    @Resource
    private SingQuesService singQuesService;
    //更新试题
    @PutMapping("/sing_Update/{questype}")
    public ApiResult updateQues(@RequestBody SingQues singQues, @PathVariable("questype") String questype) {
        int res;
        res=singQuesService.update(singQues);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
    //删除试题
    @DeleteMapping("/sing_del/{quesid}")
    public ApiResult deletebyId(@PathVariable("quesid") Integer quesid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",singQuesService.deleteById(quesid));
    }
    //增加试题
    @PostMapping("/sing_Add")
    public ApiResult add(@RequestBody SingQues singQues) {
        int res = singQuesService.add(singQues);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200, "添加成功", null);
        } else {
            return ApiResultHandler.buildApiResult(400, "添加失败", null);
        }
    }
}