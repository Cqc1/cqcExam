package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.dao.CourseDao;
import com.exam.entity.Course;
import com.exam.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Course)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;


    @Override
    public IPage<Course> findAll(Page<Course> page) {
        return courseDao.findAll(page);
    }

    @Override
    public List<Course> findALLInfo() {
        return courseDao.findAllInfo();
    }

    @Override
    public Course findById(Integer courseId) {
        return courseDao.findById(courseId);
    }

    @Override
    public List<Course> findByName(String courseName) { return courseDao.findByName(courseName);
    }

    @Override
    public int deleteById(Integer courseId) {
        return courseDao.deletebyId(courseId);
    }

    @Override
    public int update(Course course) { return courseDao.updateCou(course); }

    @Override
    public int add(Course course) {
        return courseDao.add(course);
    }
}