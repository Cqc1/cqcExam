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

    List<Teacher> findByName(String teaname);

    IPage<Teacher> findAll(Page page);

    List<Teacher> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param teacherid 主键
     * @return 实例对象
     */
    Teacher queryById(Integer teacherid);

    List<Teacher> queryByInstituId(Integer institutionid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    int insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param teacherid 主键
     * @return 是否成功
     */
    int deleteById(Integer teacherid);

}