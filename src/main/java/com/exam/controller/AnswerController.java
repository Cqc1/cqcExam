package com.exam.controller;

import com.exam.entity.Answer;
import com.exam.entity.ApiResult;
import com.exam.service.AnswerService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    //阅卷查询
    @GetMapping("/preview/{examid}/{stuid}")
    public ApiResult Preview(@PathVariable("examid") Integer examid,@PathVariable("stuid") Integer stuid) {
        Map<Integer, List<?>> map = new HashMap<>();
        List<Answer> res = answerService.queryByExamIdAndStuId(examid, stuid);
        /*List<Answer> singQuesRes = new ArrayList<>();     //单题题库 1
        List<Answer> multQuesRes = new ArrayList<>();     //多题题库 2
        List<Answer> fillQuesRes = new ArrayList<>();     //填空题题库 3
        List<Answer> judgeQuesRes = new ArrayList<>();   //判断题题库 4*/
        List<Answer> shortQuesRes = new ArrayList<>();
        if(!res.isEmpty()) {
            for (int i = 0; i < res.size(); i++) {
               /* if (res.get(i).getQuestype() == 1) {
                    singQuesRes.add(res.get(i));
                } else if (res.get(i).getQuestype() == 2) {
                    multQuesRes.add(res.get(i));
                } else if (res.get(i).getQuestype() == 3) {
                    fillQuesRes.add(res.get(i));
                } else if (res.get(i).getQuestype() == 4) {
                    judgeQuesRes.add(res.get(i));
                } else {*/
               if(res.get(i).getQuestype() != 1&&res.get(i).getQuestype() != 2&&
                       res.get(i).getQuestype() != 3&&res.get(i).getQuestype() != 4){
                   System.out.println(res.get(i).toString());
                   shortQuesRes.add(res.get(i));
                   System.out.println("shortQuesRes.isEmpty()");

               }

               /* }*/
            }
           /* System.out.println(shortQuesRes.isEmpty());
            if(!singQuesRes.isEmpty()){
                map.put(1, singQuesRes);
            }
            if(!multQuesRes.isEmpty()){
                map.put(2, multQuesRes);
            }
            if(!fillQuesRes.isEmpty()){
                map.put(3, fillQuesRes);
            }
            if(!judgeQuesRes.isEmpty()){
                map.put(4, judgeQuesRes);
            }*/
           /* if(!shortQuesRes.isEmpty()){
                System.out.println(shortQuesRes.toArray());
                map.put(5, shortQuesRes);
                System.out.println("map.put(5, shortQuesRes);");
            }*/
            return ApiResultHandler.buildApiResult(200,"请求成功",shortQuesRes);
          /*  return  map;*/
        }else{
            return ApiResultHandler.buildApiResult(404,"查询的考生答案不存在",null);
        }
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
                (answer.get(i)).setAnswerid(answer1.getAnswerid());
                System.out.println(answer1.getAnswerid()+"======"+answer.get(i).toString());
                Answer res = answerService.update(answer.get(i));
                if (res == null) {
                    return ApiResultHandler.buildApiResult(400, "更新失败", null);
                }
            }

        }
        return ApiResultHandler.buildApiResult(200, "添加成功", null);
    }

}