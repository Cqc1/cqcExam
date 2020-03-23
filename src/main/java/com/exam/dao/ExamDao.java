package com.exam.dao;

import com.exam.entity.Exam;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Exam)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-24 00:07:12
 */
public interface ExamDao {

    /**
     * 通过ID查询单条数据
     *
     * @param examid 主键
     * @return 实例对象
     */
    Exam queryById(Integer examid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Exam> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param exam 实例对象
     * @return 对象列表
     */
    List<Exam> queryAll(Exam exam);

    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 影响行数
     */
    int insert(Exam exam);

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 影响行数
     */
    int update(Exam exam);

    /**
     * 通过主键删除数据
     *
     * @param examid 主键
     * @return 影响行数
     */
    int deleteById(Integer examid);

}