package com.exam.dao;

import com.exam.entity.Admin;
import com.exam.entity.Student;
import com.exam.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginDao {

    @Select("select adminId,adminName,adminPwd,sex,email,tel,role from admin where adminId = #{username} and adminPwd = #{password}")
    public Admin adminLogin(Integer username, String password);

    @Select("select teaId,teaName,teaPwd,institutionid,sex,tel,email," +
            "role from teacher where teaId = #{username} and teaPwd = #{password}")
    public Teacher teacherLogin(Integer username, String password);

    @Select("select stuId,stuName,stuPwd,clazzid,tel," +
            "email,sex,role from student where stuId = #{username} and stuPwd = #{password}")
    public Student studentLogin(Integer username, String password);
}
