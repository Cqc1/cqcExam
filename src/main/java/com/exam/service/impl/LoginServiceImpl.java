package com.exam.service.impl;

import com.exam.dao.LoginDao;
import com.exam.entity.Admin;
import com.exam.entity.Student;
import com.exam.entity.Teacher;
import com.exam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public Admin adminLogin(Integer username, String password) {
        return loginDao.adminLogin(username,password);
    }

    @Override
    public Teacher teacherLogin(Integer username, String password) {
        return loginDao.teacherLogin(username,password);
    }

    @Override
    public Student studentLogin(Integer username, String password) {
        return loginDao.studentLogin(username,password);
    }
}
