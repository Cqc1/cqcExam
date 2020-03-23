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
        for (int i = 0; i < compositions.size(); i++) {
            composition = compositions.get(i);
            if (composition.getQuestype() == 1&&(composition.getQuesnum()!=null)) {
                // 单选题数据库获取
                List<Integer> singNumbers = singService.findByCourse(paper.getCourseid(), item.getLevel(), composition.getQuesnum());
                if (singNumbers.isEmpty()) {
                    return ApiResultHandler.buildApiResult(400, "单选题数据库获取失败", null);
                }
                for (Integer number : singNumbers) {
                    QuesPaper quesPaper = new QuesPaper(paperid, 1, number);
                    int index = quesPaperService.add(quesPaper);
                    if (index == 0)
                        return ApiResultHandler.buildApiResult(400, "单选题组卷保存失败", null);
                }
            } else if (composition.getQuestype() == 2&&(composition.getQuesnum()!=null)) {
                // 多选题数据库获取
                List<Integer> multNumbers = multService.findByCourse(paper.getCourseid(), item.getLevel(), composition.getQuesnum());
                if (multNumbers.isEmpty()) {
                    return ApiResultHandler.buildApiResult(400, "多选题数据库获取失败", null);
                }
                for (Integer number : multNumbers) {
                    QuesPaper quesPaper = new QuesPaper(paperid, 2, number);
                    int index = quesPaperService.add(quesPaper);
                    if (index == 0)
                        return ApiResultHandler.buildApiResult(400, "多选题组卷保存失败", null);
                }
            } else if (composition.getQuestype() == 3&&(composition.getQuesnum()!=null)) {
                // 填空题数据库获取
                List<Integer> fillNumbers = fillService.findByCourse(paper.getCourseid(), item.getLevel(), composition.getQuesnum());
                if (fillNumbers.isEmpty()) {
                    return ApiResultHandler.buildApiResult(400, "填空题数据库获取失败", null);
                }
                for (Integer number : fillNumbers) {
                    QuesPaper quesPaper = new QuesPaper(paperid, 3, number);
                    int index = quesPaperService.add(quesPaper);
                    if (index == 0)
                        return ApiResultHandler.buildApiResult(400, "填空题组卷保存失败", null);
                }
            } else if (composition.getQuestype() == 4&&(composition.getQuesnum()!=null)) {
                // 判断题数据库获取
                List<Integer> judgeNumbers = judgeService.findByCourse(paper.getCourseid(), item.getLevel(), composition.getQuesnum());
                if (judgeNumbers.isEmpty()) {
                    return ApiResultHandler.buildApiResult(400, "判断题数据库获取失败", null);
                }
                for (Integer number : judgeNumbers) {
                    QuesPaper quesPaper = new QuesPaper(paperid, 4, number);
                    int index = quesPaperService.add(quesPaper);
                    if (index == 0)
                        return ApiResultHandler.buildApiResult(400, "判断题组卷保存失败", null);
                }
            } else if(composition.getQuesnum()!=null) {
                // 简答题等非客观题数据库获取
                List<Integer> shortNumbers = shortService.findByCourse(composition.getQuestype(), paper.getCourseid(), item.getLevel(), composition.getQuesnum());
                if (shortNumbers.isEmpty()) {
                    return ApiResultHandler.buildApiResult(400, "简单题等非客观题数据库获取失败", null);
                }
                for (Integer number : shortNumbers) {
                    QuesPaper quesPaper = new QuesPaper(paperid, composition.getQuestype(), number);
                    int index = quesPaperService.add(quesPaper);
                    if (index == 0)
                        return ApiResultHandler.buildApiResult(400, "简单题等非客观题组卷保存失败", null);
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

