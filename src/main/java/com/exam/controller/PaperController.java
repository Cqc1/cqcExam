package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Paper;
import com.exam.service.PaperService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
}