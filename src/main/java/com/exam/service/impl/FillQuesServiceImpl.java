package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.FillQues;
import com.exam.dao.FillQuesDao;
import com.exam.service.FillQuesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FillQues)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@Service("fillQuesService")
public class FillQuesServiceImpl implements FillQuesService {
    @Resource
    private FillQuesDao fillQuesDao;

    @Override
    public IPage<FillQues> findAll(Page<FillQues> page) {
        return fillQuesDao.findAll(page);
    }

    @Override
    public FillQues findById(Integer quesId) {
        return fillQuesDao.findById(quesId);
    }

    @Override
    public List<FillQues> findByQues(String question) {
        return fillQuesDao.findByQues(question);
    }

    @Override
    public int deleteById(Integer quesId) {
        return fillQuesDao.deletebyId(quesId);
    }

    @Override
    public int update(FillQues fillQues) {
        return fillQuesDao.updateQue(fillQues);
    }


    @Override
    public int add(FillQues fillQues) {
        return fillQuesDao.add(fillQues);
    }
}