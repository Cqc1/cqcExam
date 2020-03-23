package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.SingQues;
import com.exam.dao.SingQuesDao;
import com.exam.service.SingQuesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SingQues)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@Service("singQuesService")
public class SingQuesServiceImpl implements SingQuesService {
    @Resource
    private SingQuesDao singQuesDao;

    @Override
    public IPage<SingQues> findAll(Page<SingQues> page) {
        return singQuesDao.findAll(page);
    }

    @Override
    public SingQues findById(Integer quesId) {
        return singQuesDao.findById(quesId);
    }

    @Override
    public List<SingQues> findByQues(String question) {
        return singQuesDao.findByQues(question);
    }

    @Override
    public int deleteById(Integer quesId) {
        return singQuesDao.deletebyId(quesId);
    }

    @Override
    public int update(SingQues singQues) {
        return singQuesDao.updateQue(singQues);
    }

    @Override
    public int add(SingQues singQues) {
        return singQuesDao.add(singQues);
    }

    @Override
    public List<Integer> findByCourse(Integer courseid, String level, Integer quesNum) {
        return singQuesDao.findByCourse(courseid,level,quesNum);
    }
}