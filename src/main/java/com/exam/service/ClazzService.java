package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Clazz;

import java.util.List;

/**
 * (Clazz)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
public interface ClazzService {

    IPage<Clazz> findAll(Page page);

    List<Clazz> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param clazzid 主键
     * @return 实例对象
     */
    Clazz queryById(Integer clazzid);

    List<Clazz> queryByMajorId(Integer majorid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Clazz> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param clazz 实例对象
     * @return 实例对象
     */
    Clazz insert(Clazz clazz);

    /**
     * 修改数据
     *
     * @param clazz 实例对象
     * @return 实例对象
     */
    Clazz update(Clazz clazz);

    /**
     * 通过主键删除数据
     *
     * @param clazzid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer clazzid);

}