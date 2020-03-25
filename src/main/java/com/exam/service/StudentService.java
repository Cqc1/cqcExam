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

    List<Student> findByName(String stuname);

    IPage<Student> findAll(Page page);

    List<Student> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param studentid 主键
     * @return 实例对象
     */
    Student queryById(Integer studentid);

    List<Student> queryByClazzId(Integer clazzid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    int update(Student student);

    int updatePwd(Student student);

    /**
     * 通过主键删除数据
     *
     * @param studentid 主键
     * @return 是否成功
     */
    int deleteById(Integer studentid);
}