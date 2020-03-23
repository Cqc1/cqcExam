package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Questype;
import com.exam.dao.QuestypeDao;
import com.exam.service.QuestypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Questype)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-19 23:55:34
 */
@Service("questypeService")
public class QuestypeServiceImpl implements QuestypeService {
    @Resource
    private QuestypeDao questypeDao;

    @Override
    public IPage<Questype> findAll(Page<Questype> page) {
        return questypeDao.findAll(page);
    }

    @Override
    public List<Questype> findAll() {
        return questypeDao.findAllInfo();
    }

    @Override
    public Questype findById(Integer questype) {
        return questypeDao.findById(questype);
    }

    @Override
    public List<Questype> findByName(String quesName) {
        return questypeDao.findByName(quesName);
    }

    @Override
    public int deleteById(Integer questype) {
        return questypeDao.deletebyId(questype);
    }

    @Override
    public int update(Questype questype) {
        return questypeDao.updateQuty(questype);
    }

    @Override
    public int add(Questype questype) {
        return questypeDao.add(questype);
    }
}