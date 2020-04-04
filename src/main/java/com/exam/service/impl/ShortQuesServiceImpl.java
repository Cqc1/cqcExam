package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.ShortQues;
import com.exam.dao.ShortQuesDao;
import com.exam.service.ShortQuesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ShortQues)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@Service("shortQuesService")
public class ShortQuesServiceImpl implements ShortQuesService {
    @Resource
    private ShortQuesDao shortQuesDao;

    @Override
    public IPage<ShortQues> findAll(Page<ShortQues> page) {
        return shortQuesDao.findAll(page);
    }

    @Override
    public ShortQues findByIdType(Integer quesid, Integer questype) {
        return shortQuesDao.findByIdType(quesid,questype);
    }

    @Override
    public ShortQues findById(Integer quesId) {
        return shortQuesDao.findById(quesId);
    }

    @Override
    public List<ShortQues> findByQues(String question) {
        return shortQuesDao.findByQues(question);
    }

    @Override
    public int deleteById(Integer quesId) {
        return shortQuesDao.deletebyId(quesId);
    }

    @Override
    public int update(ShortQues shortQues) {
        return shortQuesDao.updateQue(shortQues);
    }

    @Override
    public int add(ShortQues shortQues) {
        return shortQuesDao.add(shortQues);
    }

    @Override
    public List<Integer> findByCourse(Integer questype, Integer courseid, String level, Integer quesNum) {
        return shortQuesDao.findByCourse(questype,courseid,level,quesNum);
    }

    @Override
    public List<ShortQues> findByIdAndType(Integer questype, Integer paperid) {
        return shortQuesDao.findByIdAndType(questype,paperid);
    }
}