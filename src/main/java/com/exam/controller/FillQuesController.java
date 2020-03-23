package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.FillQues;
import com.exam.service.FillQuesService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (FillQues)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@RestController
public class FillQuesController {
    /**
     * 服务对象
     */
    @Resource
    private FillQuesService fillQuesService;

    //更新试题
    @PutMapping("/fill_Update/{questype}")
    public ApiResult updateQues(@RequestBody FillQues fillQues, @PathVariable("questype") String questype) {
        int res;
        res=fillQuesService.update(fillQues);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
    //删除试题
    @DeleteMapping("/fill_del/{quesid}")
    public ApiResult deletebyId(@PathVariable("quesid") Integer quesid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",fillQuesService.deleteById(quesid));
    }
    //增加试题
    @PostMapping("/fill_Add")
    public ApiResult add(@RequestBody FillQues fillQues) {
        int res = fillQuesService.add(fillQues);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200, "添加成功", null);
        } else {
            return ApiResultHandler.buildApiResult(400, "添加失败", null);
        }
    }

}