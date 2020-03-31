package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.*;
import com.exam.service.*;
import com.exam.util.ApiResultHandler;
import com.exam.vo.PaperScore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Paper)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
public class PaperController {
    /**
     * 服务对象
     */
    @Resource
    private PaperService paperService;
    @Resource
    private SingQuesService singService;
    @Resource
    private MultQuesService multService;
    @Resource
    private FillQuesService fillService;
    @Resource
    private JudgeQuesService judgeService;
    @Resource
    private ShortQuesService shortService;
    @Resource
    private QuesPaperService quesPaperService;

    //分页查询所有试卷
    @GetMapping("/papers/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Paper> paperPage = new Page<>(page,size);
        IPage<Paper> res = paperService.findAll(paperPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有试卷",res);
    }
    //通过试卷id来查找详细信息
    @GetMapping("/paper_detail/{paperid}")
    public ApiResult findByPaperIdDet(@PathVariable("paperid") Integer paperid) {
        Paper res = paperService.findBypaperidDet(paperid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试卷不存在",null);
        }
    }
    //通过课程id来查找
    @GetMapping("/paper_courseid/{courseid}")
    public ApiResult findByCourseId(@PathVariable("courseid") Integer courseid) {
        List<Paper> res = paperService.findByCourse(courseid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试卷不存在",null);
        }
    }
    //通过组卷人来查找
    @GetMapping("/paper_user/{user}")
    public ApiResult findByUser(@PathVariable("user") String user) {
        List<Paper> res = paperService.findByUser(user);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试卷不存在",null);
        }
    }
    //通过试卷id来查找
    @GetMapping("/paper_paperid/{paperid}")
    public ApiResult findByPaperId(@PathVariable("paperid") Integer paperid) {
        Paper res = paperService.findById(paperid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试卷不存在",null);
        }
    }
    //通过试卷id来删除
    @DeleteMapping("/paper_del/{paperId}")
    public ApiResult deletebyId(@PathVariable("paperId") Integer paperId) {
        return ApiResultHandler.buildApiResult(200,"删除成功",paperService.deletebyId(paperId));
    }
    //批量删除所有选中的试卷
    @DeleteMapping("/paper/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            paperService.deletebyId(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @PutMapping("/paper_Update")
    public ApiResult updatePaper(@RequestBody Paper paper) {
        int res = paperService.updatePaper(paper);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @GetMapping("/paper_content/{paperid}")
    public Map<Integer, List<?>> findContentById(@PathVariable("paperid") Integer paperid) {
        Map<Integer, List<?>> map = new HashMap<>();
        QuesPaper res = quesPaperService.findScoreById(paperid);
        List<PaperScore> paperScores=res.getPaperScores();
        for(int i=0;i<paperScores.size();i++){
            if(paperScores.get(i).getQuestype()==1){
                List<SingQues> singQuesRes = singService.findByIdAndType(paperid);   //单题题库 1
                map.put(1,singQuesRes);
            }else if(paperScores.get(i).getQuestype()==2){
                List<MultQues> multQuesRes = multService.findByIdAndType(paperid);   //多题题库 2
                map.put(2,multQuesRes);
            }else if(paperScores.get(i).getQuestype()==3){
                List<FillQues> fillQuesRes = fillService.findByIdAndType(paperid);     //填空题题库 3
                map.put(3,fillQuesRes);
            }else if(paperScores.get(i).getQuestype()==4){
                List<JudgeQues> judgeQuesRes = judgeService.findByIdAndType(paperid);   //判断题题库 4
                map.put(4,judgeQuesRes);
            }else{
                List<ShortQues> shortQuesRes=shortService.findByIdAndType(paperScores.get(i).getQuestype(),paperid);
                map.put(paperScores.get(i).getQuestype(),shortQuesRes);
            }
        }
        return  map;
    }
}