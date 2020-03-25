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
    public List<Student> findByName(String studentName) {
        return studentDao.findByName(studentName);
    }

    @Override
    public IPage<Student> findAll(Page page) {
        return studentDao.findAll(page);
    }

    @Override
    public List<Student> selectAll() {
        return studentDao.findAll();
    }

    @Override
    public Student queryById(Integer studentid) {
        return studentDao.queryById(studentid);
    }

    @Override
    public List<Student> queryByClazzId(Integer clazzid) {
        return studentDao.queryByClazzId(clazzid);
    }

    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return studentDao.queryAllByLimit(offset, limit);
    }

    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int updatePwd(Student student) {
        return studentDao.updatePwd(student);
    }

    @Override
    public int deleteById(Integer studentid) {
        return studentDao.deleteById(studentid);
    }

}