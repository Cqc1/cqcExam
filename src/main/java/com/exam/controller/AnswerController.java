package com.exam.controller;

import com.exam.entity.Answer;
import com.exam.entity.ApiResult;
import com.exam.service.AnswerService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Answer)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
@RequestMapping("answer")
public class AnswerController {
    /**
     * 服务对象
     */
    @Resource
    private AnswerService answerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Answer selectOne(Integer id) {
        return this.answerService.queryById(id);
    }

    @PostMapping("/commit")
    public ApiResult commit(@RequestBody List<Answer> answer) {
        for (int i = 0; i < answer.size(); i++) {
            Answer answer1=answerService.querByQuesIdAndType(answer.get(i).getQuestype(),answer.get(i).getQuesid(),answer.get(i).getStuid(),answer.get(i).getExamid());
            if(answer1==null){
                Answer res = answerService.insert(answer.get(i));
                if (res == null) {
                    return ApiResultHandler.buildApiResult(400, "添加失败", null);
                }
            }else{
                Answer up=answer.get(i);
                up.setAnswerid(answer1.getAnswerid());
                Answer res = answerService.update(up);
                if (res == null) {
                    return ApiResultHandler.buildApiResult(400, "更新失败", null);
                }
            }

        }
        return ApiResultHandler.buildApiResult(200, "添加成功", null);
    }

}