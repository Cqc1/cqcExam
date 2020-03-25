package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
    @Select("stuId, stuName, stuPwd, sex, cqc_exam.student.clazzId, email, "+
            " tel, role,clazz.calName as calname "+
            "from cqc_exam.student,clazz "+
            "where cqc_exam.student.clazzid=clazz.clazzId and stuName = #{stuname}")
    List<Student> findByName(String stuname);

    /**
     * 分页查询所有学生
     * @param page
     * @return List<Paper>
     */
    IPage<Student> findAll(Page page);

    /**
     * 不分页查询所有学生
     * @return List<Paper>
     */
    List<Student> findAll();

    /**
     * 通过ID查询单条数据
     *
     * @param studentid 主键
     * @return 实例对象
     */
    Student queryById(Integer studentid);

    List<Student> queryByClazzId(Integer clazzid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    int updatePwd(Student student);

    /**
     * 通过主键删除数据
     *
     * @param studentid 主键
     * @return 影响行数
     */
    int deleteById(Integer studentid);

}