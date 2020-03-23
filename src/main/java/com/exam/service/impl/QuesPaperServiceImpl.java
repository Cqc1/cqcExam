package com.exam.service.impl;

import com.exam.dao.QuesPaperDao;
import com.exam.entity.QuesPaper;
import com.exam.service.QuesPaperService;
import com.exam.vo.QuesNumber;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (QuesPaper)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Service
public class QuesPaperServiceImpl implements QuesPaperService {
    @Resource
    private QuesPaperDao quesPaperDao;

    @Override
    public List<QuesPaper> findAll() {
        return quesPaperDao.findAll();
    }

    @Override
    public List<QuesNumber> findNumById(Integer paperid) {
        return quesPaperDao.findNumById(paperid);
    }

    @Override
    public int add(QuesPaper quesPaper) {
        return quesPaperDao.add(quesPaper);
    }

    @Override
    public QuesPaper findScoreById(Integer paperid) {
        return quesPaperDao.findScoreById(paperid);
    }

}