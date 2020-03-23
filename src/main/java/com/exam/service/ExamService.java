package com.exam.service;

import com.exam.entity.Exam;
import java.util.List;

/**
 * (Exam)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
public interface ExamService {

    /**
     * 通过ID查询单条数据
     *
     * @param examid 主键
     * @return 实例对象
     */
    Exam queryById(Integer examid);

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

}