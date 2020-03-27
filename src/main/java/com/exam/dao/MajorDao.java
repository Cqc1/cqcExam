package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Major;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Majors)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
public interface MajorDao {
    /**
     * 分页查询所有专业
     * @param page
     * @return List<Paper>
     */
    IPage<Major> findAll(Page page);

    /**
     * 不分页查询所有专业
     * @return List<Paper>
     */
    List<Major> selectAll();

    /**
     * 通过ID查询单条数据
     *
     * @param majorid 主键
     * @return 实例对象
     */
    Major queryById(Integer majorid);

    List<Major> queryByInstituId(Integer institutionid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Major> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param major 实例对象
     * @return 对象列表
     */
    List<Major> queryAll(Major major);

    /**
     * 新增数据
     *
     * @param major 实例对象
     * @return 影响行数
     */
    int insert(Major major);

    /**
     * 修改数据
     *
     * @param major 实例对象
     * @return 影响行数
     */
    int update(Major major);

    /**
     * 通过主键删除数据
     *
     * @param majorid 主键
     * @return 影响行数
     */
    int deleteById(Integer majorid);

}