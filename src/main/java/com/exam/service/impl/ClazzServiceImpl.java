package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Clazz;
import com.exam.dao.ClazzDao;
import com.exam.service.ClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Clazz)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@Service("clazzService")
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzDao clazzDao;

    @Override
    public IPage<Clazz> findAll(Page page) {
        return clazzDao.findAll(page);
    }

    @Override
    public List<Clazz> selectAll() {
        return clazzDao.selectAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param clazzid 主键
     * @return 实例对象
     */
    @Override
    public Clazz queryById(Integer clazzid) {
        return this.clazzDao.queryById(clazzid);
    }

    @Override
    public List<Clazz> queryByMajorId(Integer majorid) {
        return clazzDao.queryByMajorId(majorid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Clazz> queryAllByLimit(int offset, int limit) {
        return this.clazzDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param clazz 实例对象
     * @return 实例对象
     */
    @Override
    public Clazz insert(Clazz clazz) {
        this.clazzDao.insert(clazz);
        return clazz;
    }

    /**
     * 修改数据
     *
     * @param clazz 实例对象
     * @return 实例对象
     */
    @Override
    public Clazz update(Clazz clazz) {
        this.clazzDao.update(clazz);
        return this.queryById(clazz.getClazzid());
    }

    /**
     * 通过主键删除数据
     *
     * @param clazzid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer clazzid) {
        return this.clazzDao.deleteById(clazzid) > 0;
    }
}