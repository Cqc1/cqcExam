package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.dao.QuesDao;
import com.exam.service.QuesService;
import com.exam.vo.QuesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesServiceImpl implements QuesService {

    @Autowired
    private QuesDao quesDao;

    @Override
    public IPage<QuesVO> findAll(Page<QuesVO> page) {
        return quesDao.findAll(page);
    }

    @Override
    public List<QuesVO> findByQues(String question,String questype) {
        return quesDao.findByQues(question,questype);
    }

    @Override
    public List<QuesVO> findByType(String questype) {
        return quesDao.findByType(questype);
    }

    @Override
    public List<QuesVO> findByCourse(Integer courseid) {
        return quesDao.findByCourse(courseid);
    }
}
