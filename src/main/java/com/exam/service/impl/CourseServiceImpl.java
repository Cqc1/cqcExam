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
    public List<Course> findByName(String courseName) { return courseDao.findByName(courseName);
    }

    @Override
    public IPage<Course> findAll(Page page) {
        return courseDao.findAll(page);
    }

    @Override
    public List<Course> selectAll() {
        return courseDao.findAll();
    }

    @Override
    public Course queryById(Integer courseid) {
        return courseDao.queryById(courseid);
    }

    @Override
    public List<Course> queryByInstituId(Integer institutionid) {
        return courseDao.queryByinstituteId(institutionid);
    }

    @Override
    public List<Course> queryAllByLimit(int offset, int limit) {
        return courseDao.queryAllByLimit(offset,limit);
    }

    @Override
    public int insert(Course course) {
        return courseDao.insert(course);
    }

    @Override
    public int update(Course course) {
        return courseDao.update(course);
    }

    @Override
    public int deleteById(Integer courseid) {
        return courseDao.deleteById(courseid);
    }

}