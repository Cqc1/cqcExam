package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Exam;

import java.util.List;

/**
 * (Exam)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-24 15:00:28
 */
public interface ExamService {

    IPage<Exam> findAll(Page page,Integer isexam);

    IPage<Exam> findPage(Page page);

    List<Exam> findAll(Integer isexam);

    IPage<Exam> findByMajor(Integer majorid,Page page);

    /**
     * 通过ID查询单条数据
     *
     * @param examid 主键
     * @return 实例对象
     */
    Exam queryById(Integer examid);

    List<Exam> querByMajorId(Integer majorid);

    List<Exam> querByexName(String exname);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Exam> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    Exam insert(Exam exam);

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    Exam update(Exam exam);

    /**
     * 通过主键删除数据
     *
     * @param examid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer examid);

    Exam findOnlyExamId();

}