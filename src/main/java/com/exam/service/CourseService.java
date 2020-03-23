package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Course;

import java.util.List;

/**
 * (Course)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
public interface CourseService {


    IPage<Course> findAll(Page<Course> page);

    List<Course> findALLInfo();

    Course findById(Integer courseId);

    List<Course> findByName(String courseName);

    int deleteById(Integer courseId);

    int update(Course course);

    int add(Course course);

}