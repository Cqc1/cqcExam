package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
    /**
     * 分页查询所有学生
     * @param page
     * @return List<Student>
     */
    @Select("select * from student")
    IPage<Student> findAll(Page page);

    @Select("select * from student where stuId = #{stuid}")
    Student findById(Integer studentId);

    @Select("select * from student where stuName = #{stuname}")
    List<Student> findByName(String studentName);

    @Delete("delete from student where stuId = #{stuid}")
    int deletebyId(Integer studentId);

    /**
     *更新所有学生信息
     * @param student 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update student set stuName = #{stuname},className = #{classname}," +
            "tel = #{tel},email = #{email},stuPwd = #{stupwd},sex = #{sex},role = #{role} " +
            "where stuId = #{stuid}")
    int updateStu(Student student);

    /**
     * 更新密码
     * @param student
     * @return 受影响的记录条数
     */
    @Update("update student set stuPwd = #{stupwd} where stuId = #{stuid}")
    int updatePwd(Student student);


    @Options(useGeneratedKeys = true,keyProperty = "stuid")
    @Insert("insert into student(stuName,className,tel,email,stuPwd,sex,role) values " +
            "(#{stuname},#{classname},#{tel},#{email},#{stupwd},#{sex},#{role})")
    int add(Student student);
}