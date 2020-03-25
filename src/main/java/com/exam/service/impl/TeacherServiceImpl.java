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
    public List<Teacher> findByName(String teacherName) {
        return teacherDao.findByName(teacherName);
    }

    @Override
    public IPage<Teacher> findAll(Page page) {
        return teacherDao.findAll(page);
    }

    @Override
    public List<Teacher> selectAll() {
        return teacherDao.findAll();
    }

    @Override
    public Teacher queryById(Integer teacherid) {
        return teacherDao.queryById(teacherid);
    }

    @Override
    public List<Teacher> queryByInstituId(Integer institutionid) {
        return teacherDao.queryByinstituteId(institutionid);
    }

    @Override
    public List<Teacher> queryAllByLimit(int offset, int limit) {
        return teacherDao.queryAllByLimit(offset,limit);
    }

    @Override
    public int insert(Teacher teacher) {
        return teacherDao.insert(teacher);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherDao.update(teacher);
    }

    @Override
    public int deleteById(Integer teacherid) {
        return teacherDao.deleteById(teacherid);
    }

}