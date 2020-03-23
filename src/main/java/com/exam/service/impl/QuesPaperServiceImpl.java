package com.exam.service.impl;

import com.exam.dao.QuesPaperDao;
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
    public List<QuesNumber> findNumById(Integer paperid) {
        return quesPaperDao.findNumById(paperid);
    }

}