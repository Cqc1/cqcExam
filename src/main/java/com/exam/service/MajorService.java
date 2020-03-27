package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Major;

import java.util.List;

/**
 * (Majors)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
public interface MajorService {

    IPage<Major> findAll(Page page);

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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Major> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param major 实例对象
     * @return 实例对象
     */
    Major insert(Major major);

    /**
     * 修改数据
     *
     * @param major 实例对象
     * @return 实例对象
     */
    Major update(Major major);

    /**
     * 通过主键删除数据
     *
     * @param majorid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer majorid);

}