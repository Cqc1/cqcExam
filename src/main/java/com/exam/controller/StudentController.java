package com.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ApiResult;
import com.exam.entity.Student;
import com.exam.service.impl.StudentServiceImpl;
import com.exam.util.ApiResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Student)表控制层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/students/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Student> studentPage = new Page<>(page,size);
        IPage<Student> res = studentService.findAll(studentPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有学生",res);
    }

    @GetMapping("/student/{studentId}")
    public ApiResult findById(@PathVariable("studentId") Integer studentId) {
        Student res = studentService.queryById(studentId);
        if (res != null) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
        }
    }
    @GetMapping("/student/selectByClazzId/{clazzId}")
    public ApiResult findByClazzId(@PathVariable("clazzId") Integer clazzId) {
        List<Student> res = studentService.queryByClazzId(clazzId);
        if (!res.isEmpty()) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
        }
    }
    //按用户名查找
    @GetMapping("/stu/{stuName}")
    public ApiResult findByName(@PathVariable("stuName") String stuName) {
        List<Student> res = (List<Student>) studentService.findByName(stuName);
        if (!res.isEmpty()) {
            return ApiResultHandler.buildApiResult(200,"请求成功",res);
        } else {
            return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
        }
    }

    //批量删除所有选中的学生
    @DeleteMapping("/student/deleteByIds/{param}")
    public ApiResult deleteByIds(@PathVariable("param") String param){
        String[] ids=param.split(","); // 以逗号,为拆分的字符串
        for(String id:ids)
            studentService.deleteById(Integer.valueOf(id));
        return ApiResultHandler.buildApiResult(200,"批量删除成功",null);
    }
    @DeleteMapping("/student/{studentId}")
    public ApiResult deletebyId(@PathVariable("studentId") Integer studentId) {
        return ApiResultHandler.buildApiResult(200,"删除成功",studentService.deleteById(studentId));
    }

    @PutMapping("/studentPWD")
    public ApiResult updatePwd(@RequestBody Student student) {
        studentService.updatePwd(student);
        return ApiResultHandler.buildApiResult(200,"密码更新成功",null);
    }
    @PutMapping("/student")
    public ApiResult updateStu(@RequestBody Student student) {
        System.out.println("执行更新方法");
        int res = studentService.update(student);
        if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"更新成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"更新失败",res);
    }

    @PostMapping("/student")
    public ApiResult add(@RequestBody Student student) {
        int res = studentService.insert(student);
        if (res == 1) {
            return ApiResultHandler.buildApiResult(200,"添加成功",null);
        }else {
            return ApiResultHandler.buildApiResult(400,"添加失败",null);
        }
    }
}