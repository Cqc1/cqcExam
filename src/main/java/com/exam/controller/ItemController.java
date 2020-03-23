package com.exam.controller;

import com.exam.entity.Paper;
import com.exam.service.PaperService;
import com.exam.service.impl.*;
import com.exam.util.ApiResultHandler;
import com.exam.vo.Composition;
import com.exam.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

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
    @Autowired
    PaperService paperService;

    //提交组卷信息
    @PostMapping("/item")
    public void ItemController(@RequestBody Item item) {
        Paper paper=new Paper();
        paper.setCourseid(item.getCourseid());
        paper.setUser(item.getUser());
        paper.setDescription(item.getDescription());
        paperService.add(paper);
        Integer paperid=(paperService.findOnlyPaperId()).getPaperid();
        List<Composition> compositions= item.getComposition();
        for(int i=0;i<compositions.size();i++){
            if(compositions.get(i).getQuestype()==1){
                // 单选题数据库获取
                List<Integer>  singNumbers = multiQuestionService.findBySubject(item.getSubject(), changeNumber);
                if(changeNumbers==null){
                    return ApiResultHandler.buildApiResult(400,"选择题数据库获取失败",null);
                }
                for (Integer number : changeNumbers) {
                    PaperManage paperManage = new PaperManage(paperId,1,number);
                    int index = paperService.add(paperManage);
                    if(index==0)
                        return ApiResultHandler.buildApiResult(400,"选择题组卷保存失败",null);
                }
            }
            System.out.println(compositions.get(i).getQuesnum());
        }
    }
//        // 单选题
//        Integer singNumber = item.getMap().get(1);
//        // 多选题
//        Integer multNumber = item.getMap().get(2);
//        // 填空题
//        Integer fillNumber = item.getMap().get(3);
//        // 判断题
//        Integer judgeNumber = item.getMap().get(4);
//        // 简答等其他题
//        Integer shortNumber = item.getMap().get(5);
//        //所属课程id
//        Integer courseid=item.getCourseid();

//        // 选择题数据库获取
//        List<Integer>  changeNumbers = multiQuestionService.findBySubject(item.getSubject(), changeNumber);
//        if(changeNumbers==null){
//            return ApiResultHandler.buildApiResult(400,"选择题数据库获取失败",null);
//        }
//        for (Integer number : changeNumbers) {
//            PaperManage paperManage = new PaperManage(paperId,1,number);
//            int index = paperService.add(paperManage);
//            if(index==0)
//                return ApiResultHandler.buildApiResult(400,"选择题组卷保存失败",null);
//        }
//
//        // 填空题
//        List<Integer> fills = fillQuestionService.findBySubject(item.getSubject(), fillNumber);
//        if(fills==null)
//            return ApiResultHandler.buildApiResult(400,"填空题数据库获取失败",null);
//        for (Integer fillNum : fills) {
//            PaperManage paperManage = new PaperManage(paperId,2,fillNum);
//            int index = paperService.add(paperManage);
//            if(index==0)
//                return ApiResultHandler.buildApiResult(400,"填空题题组卷保存失败",null);
//        }
//        // 判断题
//        List<Integer> judges = judgeQuestionService.findBySubject(item.getSubject(), judgeNumber);
//        if(fills==null)
//            return ApiResultHandler.buildApiResult(400,"判断题数据库获取失败",null);
//        for (Integer judge : judges) {
//            PaperManage paperManage = new PaperManage(paperId,3,judge);
//            int index = paperService.add(paperManage);
//            if(index==0)
//                return ApiResultHandler.buildApiResult(400,"判断题题组卷保存失败",null);
//        }
//
//
//          return ApiResultHandler.buildApiResult(200,"试卷组卷成功",null);
}
