package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:24
 */
@Data
public class Admin implements Serializable {

    private static final long serialVersionUID = -98041677407811635L;
    /**
    * 管理员账号
    */
    //自增主键注释
    @TableId(type= IdType.AUTO)
    private Integer adminid;
    /**
    * 管理员姓名
    */
    private String adminname;
    /**
    * 管理员密码
    */
    private String adminpwd;
    /**
    * 性别
    */
    private String sex;
    /**
    * 邮箱地址
    */
    private String email;
    /**
    * 电话号码
    */
    private String tel;
    /**
    * 角色（0：管理员、1：教师、2：学生）
    */
    private String role;


}