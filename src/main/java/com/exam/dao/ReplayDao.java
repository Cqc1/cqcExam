package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.entity.Replay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 回复表(Replay)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface ReplayDao extends BaseMapper<Replay> {

    /**
     * 通过ID查询单条数据
     *
     * @param replayid 主键
     * @return 实例对象
     */
    Replay queryById(Integer replayid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Replay> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param replay 实例对象
     * @return 对象列表
     */
    List<Replay> queryAll(Replay replay);

    /**
     * 新增数据
     *
     * @param replay 实例对象
     * @return 影响行数
     */
    int insert(Replay replay);

    /**
     * 修改数据
     *
     * @param replay 实例对象
     * @return 影响行数
     */
    int update(Replay replay);

    /**
     * 通过主键删除数据
     *
     * @param replayid 主键
     * @return 影响行数
     */
    int deleteById(Integer replayid);

}