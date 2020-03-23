package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.JudgeQues;
import com.exam.service.JudgeQuesService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (JudgeQues)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@RestController
public class JudgeQuesController {
    /**
     * 服务对象
     */
    @Resource
    private JudgeQuesService judgeQuesService;
    //更新试题
    @PutMapping("/judge_Update/{questype}")
    public ApiResult updateQues(@RequestBody JudgeQues judgeQues, @PathVariable("questype") String questype) {
        int res;
        res=judgeQuesService.update(judgeQues);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }
    //删除试题
    @DeleteMapping("/judge_del/{quesid}")
    public ApiResult deletebyId(@PathVariable("quesid") Integer quesid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",judgeQuesService.deleteById(quesid));
    }
    //增加试题
    @PostMapping("/judge_Add")
    public ApiResult add(@RequestBody JudgeQues judgeQues) {
        int res = judgeQuesService.add(judgeQues);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200, "添加成功", null);
        } else {
            return ApiResultHandler.buildApiResult(400, "添加失败", null);
        }
    }
}