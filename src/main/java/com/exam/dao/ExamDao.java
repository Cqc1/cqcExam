package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Exam)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-24 15:00:28
 */
public interface ExamDao {


    /**
     * 分页查询所有试卷
     * @param page
     * @return List<Paper>
     */
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

    /**
     * 查询最后一条记录的examId,返回给前端达到自增效果
     * @return examId
     */
    @Select("select examId from exam order by examId desc limit 1")
    Exam findOnlyExamId();

}