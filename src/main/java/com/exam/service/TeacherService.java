package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
public interface TeacherService {

    IPage<Teacher> findAll(Page<Teacher> page);

    public Teacher findById(Integer teacherId);

    List<Teacher> findByName(String teacherName);

    public int deleteById(Integer teacherId);

    public int update(Teacher teacher);

    public int add(Teacher teacher);

}