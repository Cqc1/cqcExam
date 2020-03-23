package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Course)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface CourseDao extends BaseMapper<Course> {

    /**
     * 分页查询所有课程
     * @param page
     * @return List<Course>
     */
    @Select("select * from course")
    IPage<Course> findAll(Page page);

    //不分页查询
    @Select("select * from course")
    List<Course> findAllInfo();

    @Select("select * from course where courseId = #{courseid}")
    Course findById(Integer courseid);

    @Select("select * from course where couName = #{couname}")
    List<Course> findByName(String couname);

    @Delete("delete from course where courseId = #{courseid}")
    int deletebyId(Integer courseid);

    /**
     *更新所有课程信息
     * @param course 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update course set couName = #{couname},couPeriod = #{couperiod}," +
            "credit = #{credit} " +
            "where courseId = #{courseid}")
    int updateCou(Course course);

    @Options(useGeneratedKeys = true,keyProperty = "courseid")
    @Insert("insert into course(couName,couPeriod,credit) values " +
            "(#{couname},#{couperiod},#{credit})")
    int add(Course course);

}