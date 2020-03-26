package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Institution;

import java.util.List;

/**
 * (Institution)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
public interface InstitutionService {

    IPage<Institution> findAll(Page page);

    List<Institution> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param institutionid 主键
     * @return 实例对象
     */
    Institution queryById(Integer institutionid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Institution> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param institution 实例对象
     * @return 实例对象
     */
    Institution insert(Institution institution);

    /**
     * 修改数据
     *
     * @param institution 实例对象
     * @return 实例对象
     */
    Institution update(Institution institution);

    /**
     * 通过主键删除数据
     *
     * @param institutionid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer institutionid);

    //多对多级联查询

    List<Institution> findAllMajorList();

}