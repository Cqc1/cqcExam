package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Score;

import java.util.List;

/**
 * (Score)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
public interface ScoreService {



    /**
     * 分页查询所有分数
     * @param page
     * @return List<Score>
     */
    IPage<Score> findAll(Page page);

    /**
     * 不分页查询所有分数
     */
    List<Score> findAll();
    /**
     * 通过ID查询单条数据
     *
     * @param scoreid 主键
     * @return 实例对象
     */
    Score queryById(Integer scoreid);

    /**
     * 通过ID查询单条数据
     *
     * @param stuid 主键
     * @return 实例对象
     */
    List<Score> queryByStuId(Integer stuid);

    /**
     * 通过ID查询单条数据
     *
     * @param examid 主键
     * @return 实例对象
     */
    List<Score> queryByExamId(Integer examid,Integer ispreview);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Score> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score insert(Score score);

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    Score update(Score score);

    /**
     * 通过主键删除数据
     *
     * @param scoreid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer scoreid);

}