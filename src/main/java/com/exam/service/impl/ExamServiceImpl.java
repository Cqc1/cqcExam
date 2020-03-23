package com.exam.service.impl;

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
 * @since 2020-03-24 00:07:12
 */
@Service("examService")
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamDao examDao;

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
}