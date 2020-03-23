package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.MultQues;
import com.exam.service.MultQuesService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MultQues)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@RestController
public class MultQuesController {
    /**
     * 服务对象
     */
    @Resource
    private MultQuesService multQuesService;
    //更新试题
    @PutMapping("/mult_Update/{questype}")
    public ApiResult updateQues(@RequestBody MultQues multQues, @PathVariable("questype") String questype) {
        int res;
        res=multQuesService.update(multQues);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
    //删除试题
    @DeleteMapping("/mult_del/{quesid}")
    public ApiResult deletebyId(@PathVariable("quesid") Integer quesid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",multQuesService.deleteById(quesid));
    }
    //增加试题
    @PostMapping("/mult_Add")
    public ApiResult add(@RequestBody MultQues multQues) {
        int res = multQuesService.add(multQues);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200, "添加成功", null);
        } else {
            return ApiResultHandler.buildApiResult(400, "添加失败", null);
        }
    }
}