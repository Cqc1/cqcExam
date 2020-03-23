package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
public interface StudentService {


    IPage<Student> findAll(Page<Student> page);

    Student findById(Integer studentId);

    List<Student> findByName(String studentName);

    int deleteById(Integer studentId);

    int update(Student student);

    int updatePwd(Student student);

    int add(Student student);
}