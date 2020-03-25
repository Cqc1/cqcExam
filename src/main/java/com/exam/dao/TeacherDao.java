package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {

    @Select("teaId, teaName, teaPwd, sex, cqc_exam.teacher.institutionId, email, "+
            " tel, role,institution.instituName as instituname "+
            "cqc_exam.teacher,institution "+
            "where cqc_exam.teacher.institutionId=institution.institutionId and teaName = #{teaname}")
    List<Teacher> findByName(String teaname);

    /**
     * 分页查询所有教师
     * @param page
     * @return List<Paper>
     */
    IPage<Teacher> findAll(Page page);

    /**
     * 不分页查询所有教师
     * @return List<Paper>
     */
    List<Teacher> findAll();

    /**
     * 通过ID查询单条数据
     *
     * @param teacherid 主键
     * @return 实例对象
     */
    Teacher queryById(Integer teacherid);

    List<Teacher> queryByinstituteId(Integer institutionid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param teacher 实例对象
     * @return 对象列表
     */
    List<Teacher> queryAll(Teacher teacher);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param teacherid 主键
     * @return 影响行数
     */
    int deleteById(Integer teacherid);

}