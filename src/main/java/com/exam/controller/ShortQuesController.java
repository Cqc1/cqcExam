package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.ShortQues;
import com.exam.service.ShortQuesService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ShortQues)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@RestController
public class ShortQuesController {
    /**
     * 服务对象
     */
    @Resource
    private ShortQuesService shortQuesService;
    //更新试题
    @PutMapping("/short_Update/{questype}")
    public ApiResult updateQues(@RequestBody ShortQues shortQues, @PathVariable("questype") String questype) {
        int res;
        res=shortQuesService.update(shortQues);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
    //删除试题
    @DeleteMapping("/short_del/{quesid}")
    public ApiResult deletebyId(@PathVariable("quesid") Integer quesid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",shortQuesService.deleteById(quesid));
    }
    //增加试题
    @PostMapping("/short_Add")
    public ApiResult add(@RequestBody ShortQues shortQues) {
        int res = shortQuesService.add(shortQues);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200, "添加成功", null);
        } else {
            return ApiResultHandler.buildApiResult(400, "添加失败", null);
        }
    }
}