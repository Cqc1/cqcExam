package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.dao.StudentDao;
import com.exam.entity.Student;
import com.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public IPage<Student> findAll(Page<Student> page) {
        return studentDao.findAll(page);
    }

    @Override
    public Student findById(Integer studentId) {
        return studentDao.findById(studentId);
    }

    @Override
    public List<Student> findByName(String studentName) {
        return studentDao.findByName(studentName);
    }

    @Override
    public int deleteById(Integer studentId) {
        return studentDao.deletebyId(studentId);
    }

    @Override
    public int update(Student student) {
        return studentDao.updateStu(student);
    }

    @Override
    public int updatePwd(Student student) {
        return studentDao.updatePwd(student);
    }

    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }
}