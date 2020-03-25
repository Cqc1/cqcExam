package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Course;
import com.exam.service.impl.CourseServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Course)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/courses/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Course> coursePage = new Page<>(page,size);
        IPage<Course> res = courseService.findAll(coursePage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有课程",res);
    }
    //不分页查询
    @GetMapping("/courseInfo")
    public ApiResult findAllInfo() {
        ApiResult apiResult;
        apiResult = ApiResultHandler.buildApiResult(200, "请求成功！", courseService.selectAll());
        return apiResult;
    }
    @GetMapping("/course/{courseId}")
    public ApiResult findById(@PathVariable("courseId") Integer courseId) {
        Course res = courseService.queryById(courseId);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的课程不存在",null);
        }
    }
    //按课程名查找
    @GetMapping("/cou/{couName}")
    public ApiResult findByName(@PathVariable("couName") String couName) {
        List<Course> res = (List<Course>) courseService.findByName(couName);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的课程不存在",null);
        }
    }

    //批量删除所有选中的课程
    @DeleteMapping("/course/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            courseService.deleteById(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @DeleteMapping("/course/{courseId}")
    public ApiResult deletebyId(@PathVariable("courseId") Integer courseId) {
        return ApiResultHandler.buildApiResult(200,"删除成功",courseService.deleteById(courseId));
    }

    @PutMapping("/course")
    public ApiResult updateCourse(@RequestBody Course course) {
        int res = courseService.update(course);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/course")
    public ApiResult add(@RequestBody Course course) {
        int res = courseService.update(course);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }

}