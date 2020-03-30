package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.MultQues;
import com.exam.dao.MultQuesDao;
import com.exam.service.MultQuesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MultQues)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@Service("multQuesService")
public class MultQuesServiceImpl implements MultQuesService {
    @Resource
    private MultQuesDao multQuesDao;

    @Override
    public IPage<MultQues> findAll(Page<MultQues> page) {
        return multQuesDao.findAll(page);
    }

    @Override
    public MultQues findById(Integer quesId) {
        return multQuesDao.findById(quesId);
    }

    @Override
    public List<MultQues> findByQues(String question) {
        return multQuesDao.findByQues(question);
    }

    @Override
    public int deleteById(Integer quesId) {
        return multQuesDao.deletebyId(quesId);
    }

    @Override
    public int update(MultQues multQues) {
        return multQuesDao.updateQue(multQues);
    }

    @Override
    public int add(MultQues multQues) {
        return multQuesDao.add(multQues);
    }

    @Override
    public List<Integer> findByCourse(Integer courseid, String level, Integer quesNum) {
        return multQuesDao.findByCourse(courseid,level,quesNum);
    }

    @Override
    public List<MultQues> findByIdAndType(Integer paperid) {
        return multQuesDao.findByIdAndType(paperid);
    }
}