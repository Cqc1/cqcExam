package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Paper;
import com.exam.dao.PaperDao;
import com.exam.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Paper)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperDao paperDao;

    @Override
    public IPage<Paper> findAll(Page page) {
        return paperDao.findAll(page);
    }

    @Override
    public Paper findById(Integer paperid) {
        return paperDao.findById(paperid);
    }

    @Override
    public Paper findBypaperidDet(Integer paperid) {
        return paperDao.findBypaperidDet(paperid);
    }

    @Override
    public List<Paper> findByCourse(Integer courseid) {
        return paperDao.findByCourse(courseid);
    }

    @Override
    public List<Paper> findByUser(String user) {
        return paperDao.findByUser(user);
    }

    @Override
    public int deletebyId(Integer paperid) {
        return paperDao.deletebyId(paperid);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    @Override
    public int add(Paper paper) {
        return paperDao.add(paper);
    }

    @Override
    public Paper findOnlyPaperId() {
        return paperDao.findOnlyPaperId();
    }
}