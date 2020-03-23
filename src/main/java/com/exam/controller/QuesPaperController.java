package com.exam.controller;

import com.exam.entity.ApiResult;
import com.exam.service.QuesPaperService;
import com.exam.util.ApiResultHandler;
import com.exam.vo.QuesNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (QuesPaper)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
public class QuesPaperController {
    /**
     * 服务对象
     */
    @Resource
    private QuesPaperService quesPaperService;

    /*根据试卷id来查询各种试题的数量*/
    @GetMapping("/que_paper/{paperid}")
    public ApiResult findById(@PathVariable("paperid") Integer paperid) {
        List<QuesNumber> res = quesPaperService.findNumById(paperid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的试卷不存在",null);
        }
    }

}