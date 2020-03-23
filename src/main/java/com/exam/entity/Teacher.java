package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Data
public class Teacher implements Serializable {

    private static final long serialVersionUID = 323092452497194554L;
    /**
    * 教师账号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer teaid;
    /**
    * 教师姓名
    */
    private String teaname;
    /**
    * 教师账号密码
    */
    private String teapwd;
    /**
    * 性别
    */
    private String sex;
    /**
    * 院系名称
    */
    private String yuanname;
    
    private String email;
    /**
    * 教师电话
    */
    private Integer tel;
    /**
    * 角色(0:管理员、1：教师、2：学生）
    */
    private String role;

}