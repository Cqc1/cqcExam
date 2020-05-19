package com.exam.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.JudgeQues;
import com.exam.dao.JudgeQuesDao;
import com.exam.service.JudgeQuesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (JudgeQues)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-18 19:59:46
 */
@Service("judgeQuesService")
public class JudgeQuesServiceImpl implements JudgeQuesService {
    @Resource
    private JudgeQuesDao judgeQuesDao;

    @Override
    public IPage<JudgeQues> findAll(Page<JudgeQues> page) {
        return judgeQuesDao.findAll(page);
    }

    @Override
    public JudgeQues findById(Integer quesId) {
        return judgeQuesDao.findById(quesId);
    }

    @Override
    public List<JudgeQues> findByQues(String question) {
        return judgeQuesDao.findByQues(question);
    }

    @Override
    public int deleteById(Integer quesId) {
        return judgeQuesDao.deletebyId(quesId);
    }

    @Override
    public int update(JudgeQues judgeQues) {
        return judgeQuesDao.updateQue(judgeQues);
    }

    @Override
    public int add(JudgeQues judgeQues) {
        return judgeQuesDao.add(judgeQues);
    }

    @Override
    public List<Integer> findByCourse(Integer courseid, String level, Integer quesNum) {
        return judgeQuesDao.findByCourse(courseid,level,quesNum);
    }

    @Override
    public List<JudgeQues> findByIdAndType(Integer paperid) {
        return judgeQuesDao.findByIdAndType(paperid);
    }

    @Override
    public List<Integer> findByMore(Integer courseid, String level, String chapter, Integer quesNum) {
        return judgeQuesDao.findByMore(courseid, level, chapter, quesNum);
    }
}