package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.entity.Paper;
import com.exam.entity.QuesPaper;
import com.exam.service.PaperService;
import com.exam.service.QuesPaperService;
import com.exam.service.impl.*;
import com.exam.util.ApiResultHandler;
import com.exam.vo.Composition;
import com.exam.vo.Item;
import com.exam.vo.PaperScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

//    @Autowired
//    private QuesServiceImpl quesService;
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
    @Autowired
    private PaperService paperService;
    @Autowired
    private QuesPaperService quesPaperService;

    //提交组卷信息
    @PostMapping("/item")
    public ApiResult ItemController(@RequestBody Item item) {
        Paper paper = new Paper();
        paper.setCourseid(item.getCourseid());
        System.out.println(item.getCourseid()+"====================================================================");
        paper.setUser(item.getUser());
        paper.setDescription(item.getDescription());
        System.out.println(paper.getCourseid()+"====================================================================");
        paperService.add(paper);
        Integer paperid = (paperService.findOnlyPaperId()).getPaperid();
        List<Composition> compositions = item.getComposition();
        Composition composition = new Composition();
        for (int i = 0; i < compositions.size();i++) {
            composition = compositions.get(i);
            if (composition.getQuestype() == 1&&(composition.getQuesnum()!=null)) {
                int m=1;
                List<Integer> sing=new ArrayList<>();
                System.out.println(singService.findNum(paper.getCourseid(), item.getLevel()));
                if(singService.findNum(paper.getCourseid(), item.getLevel()).intValue()>=composition.getQuesnum()){ //题库数量足够时
                    // 单选题数据库获取
                    while(sing.size()<composition.getQuesnum()){
                        if(m==11){
                            m=1;
                        }
                        List<Integer> singNumbers = singService.findByMore(paper.getCourseid(), item.getLevel(),m+"",1);
                        if (singNumbers.isEmpty()) {
                            m++;
                        }else if(!sing.contains(singNumbers.get(0))) {
                            System.out.println("未删减"+singNumbers.get(0));
                            sing.add(singNumbers.get(0));
                            singNumbers.clear();
                            m++;
                        }else{
                            m++;
                        }
                    }
                    if(sing.size()==composition.getQuesnum()){
                        for (Integer number : sing) {
                            System.out.println("排序删减"+number);
                            QuesPaper quesPaper = new QuesPaper(paperid, 1, number);
                            int index = quesPaperService.add(quesPaper);
                            if (index == 0)
                                return ApiResultHandler.buildApiResult(400, "单选题组卷保存失败", null);
                        }
                    }
                }else{
                     paperService.deletebyId(paperid);
                     return ApiResultHandler.buildApiResult(400, "单选题数据库获取失败", null);
                }
            } else if (composition.getQuestype() == 2&&(composition.getQuesnum()!=null)) {
                // 多选题数据库获取
                int m=1;
                List<Integer> mult=new ArrayList<>();
                System.out.println(multService.findNum(paper.getCourseid(), item.getLevel()));
                if(multService.findNum(paper.getCourseid(), item.getLevel()).intValue()>=composition.getQuesnum()){ //题库数量足够时
                    while(mult.size()<composition.getQuesnum()){
                        if(m==11){
                            m=1;
                        }
                        List<Integer> multNumbers = multService.findByMore(paper.getCourseid(), item.getLevel(),m+"",1);
                        if (multNumbers.isEmpty()) {
                            m++;
                        }else if(!mult.contains(multNumbers.get(0))) {
                            mult.add(multNumbers.get(0));
                            multNumbers.clear();
                            m++;
                        }else{
                            m++;
                        }
                    }
                    if(mult.size()==composition.getQuesnum()){
                        for (Integer number : mult) {
                            QuesPaper quesPaper = new QuesPaper(paperid, 2, number);
                            int index = quesPaperService.add(quesPaper);
                            if (index == 0)
                                return ApiResultHandler.buildApiResult(400, "多选题组卷保存失败", null);
                        }
                    }
                }else{
                    paperService.deletebyId(paperid);
                    return ApiResultHandler.buildApiResult(400, "多选题数据库获取失败", null);
                }
            } else if (composition.getQuestype() == 3&&(composition.getQuesnum()!=null)) {
                // 填空题数据库获取
                int m=1;
                List<Integer> fill=new ArrayList<>();
                System.out.println(fillService.findNum(paper.getCourseid(), item.getLevel()));
                if(fillService.findNum(paper.getCourseid(), item.getLevel()).intValue()>=composition.getQuesnum()){ //题库数量足够时
                    while(fill.size()<composition.getQuesnum()){
                        if(m==11){
                            m=1;
                        }
                        List<Integer> fillNumbers = fillService.findByMore(paper.getCourseid(), item.getLevel(),m+"",1);
                        if (fillNumbers.isEmpty()) {
                            m++;
                        }else if(!fill.contains(fillNumbers.get(0))) {
                            fill.add(fillNumbers.get(0));
                            fillNumbers.clear();
                            m++;
                        }else{
                            m++;
                        }
                    }
                    if(fill.size()==composition.getQuesnum()){
                        for (Integer number : fill) {
                            QuesPaper quesPaper = new QuesPaper(paperid, 3, number);
                            int index = quesPaperService.add(quesPaper);
                            if (index == 0)
                                return ApiResultHandler.buildApiResult(400, "填空题组卷保存失败", null);
                        }
                    }
                }else{
                    paperService.deletebyId(paperid);
                    return ApiResultHandler.buildApiResult(400, "填空题数据库获取失败", null);
                }
            } else if (composition.getQuestype() == 4&&(composition.getQuesnum()!=null)) {
                // 判断题数据库获取
                int m=1;
                List<Integer> judge=new ArrayList<>();
                System.out.println(judgeService.findNum(paper.getCourseid(), item.getLevel()));
                if(judgeService.findNum(paper.getCourseid(), item.getLevel()).intValue()>=composition.getQuesnum()){ //题库数量足够时
                    while(judge.size()<composition.getQuesnum()){
                        if(m==11){
                            m=1;
                        }
                        List<Integer> judgeNumbers = judgeService.findByMore(paper.getCourseid(), item.getLevel(),m+"",1);
                        if (judgeNumbers.isEmpty()) {
                            m++;
                        }else if(!judge.contains(judgeNumbers.get(0))) {
                            judge.add(judgeNumbers.get(0));
                            judgeNumbers.clear();
                            m++;
                        }else{
                            m++;
                        }
                    }
                    if(judge.size()==composition.getQuesnum()){
                        for (Integer number : judge) {
                            QuesPaper quesPaper = new QuesPaper(paperid, 4, number);
                            int index = quesPaperService.add(quesPaper);
                            if (index == 0)
                                return ApiResultHandler.buildApiResult(400, "判断题组卷保存失败", null);
                        }
                    }
                }else{
                    paperService.deletebyId(paperid);
                    return ApiResultHandler.buildApiResult(400, "判断题数据库获取失败", null);
                }
            } else if(composition.getQuesnum()!=null) {
                // 简答题等非客观题数据库获取
                int m=1;
                List<Integer> shor=new ArrayList<>();
                System.out.println(shortService.findNum(composition.getQuestype(),paper.getCourseid(), item.getLevel()));
                if(shortService.findNum(composition.getQuestype(),paper.getCourseid(), item.getLevel()).intValue()>=composition.getQuesnum()){ //题库数量足够时
                    while(shor.size()<composition.getQuesnum()){
                        if(m==11){
                            m=1;
                        }
                        List<Integer> shortNumbers = shortService.findByMore(composition.getQuestype(),paper.getCourseid(), item.getLevel(),m+"",1);
                        if (shortNumbers.isEmpty()) {
                            m++;
                        }else if(!shor.contains(shortNumbers.get(0))) {
                            shor.add(shortNumbers.get(0));
                            shortNumbers.clear();
                            m++;
                        }else{
                            m++;
                        }
                    }
                    if(shor.size()==composition.getQuesnum()){
                        for (Integer number : shor) {
                            QuesPaper quesPaper = new QuesPaper(paperid, composition.getQuestype(), number);
                            int index = quesPaperService.add(quesPaper);
                            if (index == 0)
                                return ApiResultHandler.buildApiResult(400, "非客观题组卷保存失败", null);
                        }
                    }
                }else{
                    paperService.deletebyId(paperid);
                    return ApiResultHandler.buildApiResult(400, "非客观题数据库获取失败", null);
                }
            }
        }
        Paper paperUpate = paper;
        QuesPaper quesPaper=quesPaperService.findScoreById(paperid);
        int Score=0;
        for(PaperScore paperScore:quesPaper.getPaperScores()){
            Score+=paperScore.getTypescore();
        }
        paperUpate.setTotalscore(Score);
        int res=paperService.updatePaper(paperUpate);
        if(res != 0) {
            return ApiResultHandler.buildApiResult(200, "试卷组卷成功", null);
        }else{
            return ApiResultHandler.buildApiResult(400, "试卷组卷失败", null);
        }
    }
}

