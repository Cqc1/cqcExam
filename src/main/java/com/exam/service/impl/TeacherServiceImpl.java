package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.dao.TeacherDao;
import com.exam.entity.Teacher;
import com.exam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public IPage<Teacher> findAll(Page<Teacher> page) {
        return teacherDao.findAll(page);
    }

    @Override
    public Teacher findById(Integer teacherId) {
        return teacherDao.findById(teacherId);
    }

    @Override
    public List<Teacher> findByName(String teacherName) {
        return teacherDao.findByName(teacherName);
    }

    @Override
    public int deleteById(Integer teacherId) {
        return teacherDao.deleteById(teacherId);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherDao.updateTea(teacher);
    }

    @Override
    public int add(Teacher teacher) {
        return teacherDao.add(teacher);
    }
}