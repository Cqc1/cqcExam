package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Major;
import com.exam.dao.MajorDao;
import com.exam.service.MajorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Major)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@Service("majorService")
public class MajorServiceImpl implements MajorService {
    @Resource
    private MajorDao majorDao;

    @Override
    public IPage<Major> findAll(Page page) {
        return majorDao.findAll(page);
    }

    @Override
    public List<Major> selectAll() {
        return majorDao.selectAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param majorid 主键
     * @return 实例对象
     */
    @Override
    public Major queryById(Integer majorid) {
        return this.majorDao.queryById(majorid);
    }

    @Override
    public List<Major> queryByInstituId(Integer institutionid) {
        return majorDao.queryByInstituId(institutionid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Major> queryAllByLimit(int offset, int limit) {
        return this.majorDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param major 实例对象
     * @return 实例对象
     */
    @Override
    public Major insert(Major major) {
        this.majorDao.insert(major);
        return major;
    }

    /**
     * 修改数据
     *
     * @param major 实例对象
     * @return 实例对象
     */
    @Override
    public Major update(Major major) {
        this.majorDao.update(major);
        return this.queryById(major.getMajorid());
    }

    /**
     * 通过主键删除数据
     *
     * @param majorid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer majorid) {
        return this.majorDao.deleteById(majorid) > 0;
    }
}