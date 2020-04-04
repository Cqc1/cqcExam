package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.*;
import com.exam.service.impl.*;
import com.exam.util.ApiResultHandler;
import com.exam.vo.QuesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuesController {

    @Autowired
    private QuesServiceImpl quesService;
    @Autowired
    private SingQuesServiceImpl singService;
    @Autowired
    private MultQuesServiceImpl multService;
    @Autowired
    private FillQuesServiceImpl fillService;
    @Autowired
    private JudgeQuesServiceImpl judgeService;
    @Autowired
    private ShortQuesServiceImpl shortService;

    @GetMapping("/ques_all/{page}/{size}")
    public ApiResult findAllQuestion(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Page<QuesVO> quesVOPage = new Page<>(page,size);
        IPage<QuesVO> quesVOIPage = quesService.findAll(quesVOPage);
        return ApiResultHandler.buildApiResult(200,"查询所有题库",quesVOIPage);

    }
    //按条件(题目信息和题目类型)查找
    @GetMapping("/ques_scr/{question}/{questype}")
    public ApiResult findByName(@PathVariable("question") String question,@PathVariable("questype") String questype) {
        List<QuesVO> res = (List<QuesVO>) quesService.findByQues(question,questype);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试题不存在",null);
        }
    }
    //按题目类型查找
    @GetMapping("/ques/selectBytype/{questype}")
    public ApiResult findByType(@PathVariable("questype") String questype) {
        List<QuesVO> res = (List<QuesVO>) quesService.findByType(questype);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试题不存在",null);
        }
    }
    //按题目所属科目查找
    @GetMapping("/ques/selectBycourse/{courseid}")
    public ApiResult findByCourse(@PathVariable("courseid") Integer courseid) {
        List<QuesVO> res = (List<QuesVO>) quesService.findByCourse(courseid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试题不存在",null);
        }
    }
    //查看单个试题详情
    @GetMapping("/ques_pre/{quesid}/{questype}")
    public ApiResult findByIdType(@PathVariable("quesid") Integer quesid,@PathVariable("questype") Integer questype) {
        Object res= new Object();
        System.out.println(quesid+questype);
        System.out.println(questype.equals("1"));
        if(questype==1){
            res=singService.findById(quesid);
        }else if(questype==2){
            res=multService.findById(quesid);
        }else if(questype==3){
            res=fillService.findById(quesid);
        }else if(questype==4){
            res=judgeService.findById(quesid);
        }else {
            res=shortService.findByIdType(quesid,questype);
        }
        System.out.println(res==null);
        if (res!= null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试题不存在",null);
        }
    }
    //批量删除试题
    @DeleteMapping ("/ques_del/deleteByIds/{param}/{value}")
    public ApiResult deleteQues(@PathVariable("param") String param, @PathVariable("value") String value) {
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        if(value.equals("1")){
            for(String id:ids)
                singService.deleteById(Integer.valueOf(id));
            return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
        }else if(value.equals("2")){
            for(String id:ids)
                multService.deleteById(Integer.valueOf(id));
            return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
        }else if(value.equals("3")){
            for(String id:ids)
                fillService.deleteById(Integer.valueOf(id));
            return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
        }else if(value.equals("4")){
            for(String id:ids)
                judgeService.deleteById(Integer.valueOf(id));
            return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
        }else {
            for(String id:ids)
                shortService.deleteById(Integer.valueOf(id));
            return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
        }
    }
}
