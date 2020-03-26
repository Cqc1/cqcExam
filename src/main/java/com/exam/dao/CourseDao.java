package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Course)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface CourseDao extends BaseMapper<Course> {

    /*@Select("select courseId, couName, couPeriod, credit, "+
            "cqc_exam.course.institutionId,institution.instituName as instituname "+
            "from course,institution "+
            "where course.institutionId=institution.institutionId and couName = #{couname}")*/
    List<Course> findByName(String couname);

    /**
     * 分页查询所有课程
     * @param page
     * @return List<Paper>
     */
    IPage<Course> findAll(Page page);

    /**
     * 不分页查询所有课程
     * @return List<Paper>
     */
    List<Course> findAll();

    /**
     * 通过ID查询单条数据
     *
     * @param courseid 主键
     * @return 实例对象
     */
    Course queryById(Integer courseid);

    List<Course> queryByinstituteId(Integer institutionid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Course> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param course 实例对象
     * @return 对象列表
     */
    List<Course> queryAll(Course course);

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 影响行数
     */
    int insert(Course course);

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 影响行数
     */
    int update(Course course);

    /**
     * 通过主键删除数据
     *
     * @param courseid 主键
     * @return 影响行数
     */
    int deleteById(Integer courseid);

}