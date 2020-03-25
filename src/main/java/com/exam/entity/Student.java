package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = -46579579082928312L;
    /**
    * 学生学号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer stuid;
    /**
    * 学生姓名
    */
    private String stuname;
    /**
    * 学生账号密码
    */
    private String stupwd;
    /**
    * 性别
    */
    private String sex;
    /**
    * 班级编号
    */
    private Integer clazzid;

    /**
    * 邮箱
    */
    private String email;
    /**
    * 电话
    */
    private Integer tel;
    /**
    * 角色（0：管理员、1：教师、2：学生）
    */
    private String role;

    private Clazz clazz;//班级实体



}