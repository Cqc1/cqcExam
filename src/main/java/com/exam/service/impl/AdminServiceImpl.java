package com.exam.service.impl;

import com.exam.entity.Admin;
import com.exam.dao.AdminDao;
import com.exam.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:26
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param adminid 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer adminid) {
        return this.adminDao.queryById(adminid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getAdminid());
    }

    @Override
    public int updatePwd(Admin admin) {
        return adminDao.update(admin);
    }

    /**
     * 通过主键删除数据
     *
     * @param adminid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer adminid) {
        return this.adminDao.deleteById(adminid) > 0;
    }
}