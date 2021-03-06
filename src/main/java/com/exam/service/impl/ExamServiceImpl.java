package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Exam;
import com.exam.dao.ExamDao;
import com.exam.service.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Exam)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-24 15:00:28
 */
@Service("examService")
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamDao examDao;

    @Override
    public IPage<Exam> findAll(Page page,Integer isexam) {
        return examDao.findAll(page,isexam);
    }

    @Override
    public IPage<Exam> findPage(Page page) {
        return examDao.findPage(page);
    }

    @Override
    public List<Exam> findAll(Integer isexam) {
        return examDao.findAll(isexam);
    }

    @Override
    public IPage<Exam> findByMajor(Integer majorid, Page page) {
        return examDao.findByMajor(majorid,page);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param examid 主键
     * @return 实例对象
     */
    @Override
    public Exam queryById(Integer examid) {
        return this.examDao.queryById(examid);
    }

    @Override
    public List<Exam> querByMajorId(Integer majorid) {
        return examDao.querByMajorId(majorid);
    }

    @Override
    public List<Exam> querByexName(String exname) {
        return examDao.querByexName(exname);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Exam> queryAllByLimit(int offset, int limit) {
        return this.examDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    @Override
    public Exam insert(Exam exam) {
        this.examDao.insert(exam);
        return exam;
    }

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    @Override
    public Exam update(Exam exam) {
        this.examDao.update(exam);
        return this.queryById(exam.getExamid());
    }

    /**
     * 通过主键删除数据
     *
     * @param examid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer examid) {
        return this.examDao.deleteById(examid) > 0;
    }

    @Override
    public Exam findOnlyExamId() {
        return examDao.findOnlyExamId();
    }
}