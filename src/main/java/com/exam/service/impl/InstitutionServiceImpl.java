package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Institution;
import com.exam.dao.InstitutionDao;
import com.exam.service.InstitutionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Institution)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-24 19:55:10
 */
@Service("institutionService")
public class InstitutionServiceImpl implements InstitutionService {
    @Resource
    private InstitutionDao institutionDao;

    @Override
    public IPage<Institution> findAll(Page page) {
        return institutionDao.findAll(page);
    }

    @Override
    public List<Institution> selectAll() {
        return institutionDao.selectAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param institutionid 主键
     * @return 实例对象
     */
    @Override
    public Institution queryById(Integer institutionid) {
        return this.institutionDao.queryById(institutionid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Institution> queryAllByLimit(int offset, int limit) {
        return this.institutionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param institution 实例对象
     * @return 实例对象
     */
    @Override
    public Institution insert(Institution institution) {
        this.institutionDao.insert(institution);
        return institution;
    }

    /**
     * 修改数据
     *
     * @param institution 实例对象
     * @return 实例对象
     */
    @Override
    public Institution update(Institution institution) {
        this.institutionDao.update(institution);
        return this.queryById(institution.getInstitutionid());
    }

    /**
     * 通过主键删除数据
     *
     * @param institutionid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer institutionid) {
        return this.institutionDao.deleteById(institutionid) > 0;
    }

    @Override
    public List<Institution> findAllMajorList() {
        return institutionDao.findAllMajorList();
    }
}