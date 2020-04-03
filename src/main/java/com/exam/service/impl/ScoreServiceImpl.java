package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Score;
import com.exam.dao.ScoreDao;
import com.exam.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Score)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreDao scoreDao;

    @Override
    public IPage<Score> findAll(Page page) {
        return scoreDao.findAll(page);
    }

    @Override
    public List<Score> findAll() {
        return scoreDao.findAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param scoreid 主键
     * @return 实例对象
     */
    @Override
    public Score queryById(Integer scoreid) {
        return this.scoreDao.queryById(scoreid);
    }

    @Override
    public List<Score> queryByStuId(Integer stuid) {
        return scoreDao.queryByStuId(stuid);
    }

    @Override
    public List<Score> queryByExamId(Integer examid,Integer ispreview) {
        return scoreDao.queryByExamId(examid,ispreview);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Score> queryAllByLimit(int offset, int limit) {
        return this.scoreDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score insert(Score score) {
        this.scoreDao.insert(score);
        return score;
    }

    /**
     * 修改数据
     *
     * @param score 实例对象
     * @return 实例对象
     */
    @Override
    public Score update(Score score) {
        this.scoreDao.update(score);
        return this.queryById(score.getScoreid());
    }

    /**
     * 通过主键删除数据
     *
     * @param scoreid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer scoreid) {
        return this.scoreDao.deleteById(scoreid) > 0;
    }
}