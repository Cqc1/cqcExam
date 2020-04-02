package com.exam.service.impl;

import com.exam.entity.Answer;
import com.exam.dao.AnswerDao;
import com.exam.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Answer)表服务实现类
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerDao answerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param answerid 主键
     * @return 实例对象
     */
    @Override
    public Answer queryById(Integer answerid) {
        return this.answerDao.queryById(answerid);
    }

    @Override
    public Answer querByQuesIdAndType(Integer questype, Integer quesid,Integer stuid,Integer examid) {
        return answerDao.querByQuesIdAndType(questype, quesid,stuid,examid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Answer> queryAllByLimit(int offset, int limit) {
        return this.answerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    @Override
    public Answer insert(Answer answer) {
        this.answerDao.insert(answer);
        return answer;
    }

    /**
     * 修改数据
     *
     * @param answer 实例对象
     * @return 实例对象
     */
    @Override
    public Answer update(Answer answer) {
        this.answerDao.update(answer);
        return this.queryById(answer.getAnswerid());
    }

    /**
     * 通过主键删除数据
     *
     * @param answerid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer answerid) {
        return this.answerDao.deleteById(answerid) > 0;
    }
}