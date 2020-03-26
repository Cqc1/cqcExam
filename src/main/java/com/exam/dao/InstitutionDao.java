package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Institution;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Institution)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
public interface InstitutionDao {

    /**
     * 分页查询所有院系
     * @param page
     * @return List<Paper>
     */
    IPage<Institution> findAll(Page page);

    /**
     * 不分页查询所有院系
     * @return List<Paper>
     */
    List<Institution> selectAll();
    /**
     * 通过ID查询单条数据
     *
     * @param institutionid 主键
     * @return 实例对象
     */
    Institution queryById(Integer institutionid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Institution> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param institution 实例对象
     * @return 对象列表
     */
    List<Institution> queryAll(Institution institution);

    /**
     * 新增数据
     *
     * @param institution 实例对象
     * @return 影响行数
     */
    int insert(Institution institution);

    /**
     * 修改数据
     *
     * @param institution 实例对象
     * @return 影响行数
     */
    int update(Institution institution);

    /**
     * 通过主键删除数据
     *
     * @param institutionid 主键
     * @return 影响行数
     */
    int deleteById(Integer institutionid);

    //多对多级联查询

    List<Institution> findAllMajorList();

}