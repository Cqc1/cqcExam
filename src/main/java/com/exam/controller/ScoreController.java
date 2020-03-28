package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Score;
import com.exam.service.ScoreService;
import com.exam.util.ApiResultHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Score)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
@RequestMapping("score")
public class ScoreController {
    /**
     * 服务对象
     */
    @Resource
    private ScoreService scoreService;


    @GetMapping("/findAll/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Score> scorePage = new Page<>(page,size);
        IPage<Score> res = scoreService.findAll(scorePage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有分数",res);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param scoreid 主键
     * @return 单条数据
     */
    @GetMapping("selectById/{scoreid}")
    public ApiResult selectById(@PathVariable("scoreid")Integer scoreid) {
        Score res =scoreService.queryById(scoreid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的分数不存在",null);
        }
    }
    @GetMapping("selectByStuId/{stuid}")
    public ApiResult selectByStuId(@PathVariable("stuid")Integer stuid) {
        Score res =scoreService.queryByStuId(stuid);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的分数不存在",null);
        }
    }
    @GetMapping("selectByExamId/{examid}")
    public ApiResult selectByExamId(@PathVariable("examid")Integer examid) {
        List<Score> res =scoreService.queryByExamId(examid);
        if (!res.isEmpty()) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的分数不存在",null);
        }
    }
    //批量删除所有选中的分数
    @DeleteMapping("/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            scoreService.deleteById(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @DeleteMapping("/delete/{scoreid}")
    public ApiResult deletebyId(@PathVariable("scoreid") Integer scoreid) {
        return ApiResultHandler.buildApiResult(200,"删除成功",scoreService.deleteById(scoreid));
    }

    @PutMapping("/update")
    public ApiResult updateExam(@RequestBody Score score) {
        Score res = scoreService.update(score);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/add")
    public ApiResult add(@RequestBody Score score) {
        Score   res = scoreService.insert(score);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }
    /*@GetMapping("/OnlyExamId")
    public ApiResult findOnlyExamId() {
        Score res = scoreService.findOnlyExamId();
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"请求失败",res);
    }*/

}