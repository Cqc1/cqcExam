package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Exam;
import com.exam.service.ExamService;
import com.exam.util.ApiResultHandler;
import com.exam.util.dateTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Exam)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-24 15:00:28
 */
@RestController
@RequestMapping("exam")
public class ExamController {
    /**
     * 服务对象
     */
    @Resource
    private ExamService examService;

    @GetMapping("/findPage/{page}/{size}")
    public ApiResult findPage(@PathVariable Integer page, @PathVariable Integer size) throws ParseException {
        Page<Exam> examPage = new Page<>(page,size);
        IPage<Exam> res = examService.findPage(examPage);
        if(res!=null){
            List<Exam> exams=res.getRecords();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString=df.format(new Date());
            Date date =df.parse(dateString);
            for(int i=0;i<exams.size();i++){
                /*Date exdate = new Date(exams.get(i).getExtime());*/
                Date beginData = df.parse(exams.get(i).getExdate());
                System.out.println(date.toString() +"=====" +beginData.toString());
                System.out.println((dateTool.getDatePoor(date,beginData)) + "分钟");
                if(date.before(beginData)&&exams.get(i).getIsexam()!=2){
                    exams.get(i).setIsexam(0);
                    exams.get(i).setExamid(exams.get(i).getExamid());
                    examService.update(exams.get(i));
                }else if(((dateTool.getDatePoor(date,beginData))>(exams.get(i).getExtime()).longValue())&&exams.get(i).getIsexam()!=2){
                    exams.get(i).setIsexam(1);
                    exams.get(i).setExamid(exams.get(i).getExamid());
                    examService.update(exams.get(i));
                }
            }
            return  ApiResultHandler.buildApiResult(200,"分页查询所有考试",res);
        }
        return  ApiResultHandler.buildApiResult(400,"分页查询所有考试失败",null);
    }

    @GetMapping("/findAll/{page}/{size}/{isexam}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Integer isexam) throws ParseException {
        Page<Exam> examPage = new Page<>(page,size);
        IPage<Exam> res = examService.findAll(examPage,isexam);
        if(res!=null){
            List<Exam> exams=res.getRecords();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString=df.format(new Date());
            Date date =df.parse(dateString);
            for(int i=0;i<exams.size();i++){
                /*Date exdate = new Date(exams.get(i).getExtime());*/
                Date beginData = df.parse(exams.get(i).getExdate());
                System.out.println(date.toString() +"=====" +beginData.toString());
                System.out.println((dateTool.getDatePoor(date,beginData)) + "分钟");
                if(date.before(beginData)&&exams.get(i).getIsexam()!=2){
                    exams.get(i).setIsexam(0);
                    exams.get(i).setExamid(exams.get(i).getExamid());
                    examService.update(exams.get(i));
                }else if(((dateTool.getDatePoor(date,beginData))>(exams.get(i).getExtime()).longValue())&&exams.get(i).getIsexam()!=2){
                    exams.get(i).setIsexam(1);
                    exams.get(i).setExamid(exams.get(i).getExamid());
                    examService.update(exams.get(i));
                }
            }
        }
        IPage<Exam> res2 = examService.findAll(examPage,isexam);
        if(res2!=null){
            return  ApiResultHandler.buildApiResult(200,"分页查询所有考试",res2);
        }
        return  ApiResultHandler.buildApiResult(400,"分页查询所有考试失败",null);
    }
    @GetMapping("/exams/{isexam}")
    public ApiResult find(@PathVariable Integer isexam) {
        List<Exam> res = examService.findAll(isexam);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有考试",res);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param examid 主键
     * @return 单条数据
     */
    @GetMapping("selectById/{examid}")
    public ApiResult selectById(@PathVariable("examid")Integer examid) {
        Exam res =examService.queryById(examid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试卷不存在",null);
        }
    }
    @GetMapping("selectByexName/{exname}")
    public ApiResult selectById(@PathVariable("exname")String exname) {
        List<Exam> res =examService.querByexName(exname);
        if (!res.isEmpty()) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试卷不存在",null);
        }
    }
    @GetMapping("/findByMajorId/{majorid}/{page}/{size}")
    public ApiResult findAllByMajor(@PathVariable("majorid")Integer majorid,@PathVariable Integer page, @PathVariable Integer size) {
        Page<Exam> examPage = new Page<>(page,size);
        IPage<Exam> res = examService.findByMajor(majorid,examPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有考试",res);
    }
    @GetMapping("selectByMajorId/{majorid}")
    public List<Exam> selectByMajorId(@PathVariable("majorid")Integer majorid) {
        return this.examService.querByMajorId(majorid);
    }

    //批量删除所有选中的考试
    @DeleteMapping("/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            examService.deleteById(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @DeleteMapping("/delete/{examid}")
    public ApiResult deletebyId(@PathVariable("examid") Integer examid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",examService.deleteById(examid));
    }

    @PutMapping("/update")
    public ApiResult updateExam(@RequestBody Exam exam) {
        Exam res = examService.update(exam);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/add")
    public ApiResult add(@RequestBody Exam exam) {
         Exam  res = examService.insert(exam);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }
    @GetMapping("/OnlyExamId")
    public ApiResult findOnlyExamId() {
        Exam res = examService.findOnlyExamId();
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"请求失败",res);
    }
}