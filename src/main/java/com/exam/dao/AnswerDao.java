package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exam.entity.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Answer)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface AnswerDao extends BaseMapper<Answer> {

    /**
     * 通过ID查询单条数据
     *
     * @param answerid 主键
     * @return 实例对象
     */
    Answer queryById(Integer answerid);

    Answer querByQuesIdAndType(Integer questype,Integer quesid,Integer stuid,Integer examid);

    List<Answer> queryByExamIdAndStuId(Integer examid,Integer stuid);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Answer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param answer 实例对象
     * @return 对象列表
     */
    List<Answer> queryAll(Answer answer);

    /**
     * 新增数据
     *
     * @param answer 实例对象
     * @return 影响行数
     */
    int insert(Answer answer);

    /**
     * 修改数据
     *
     * @param answer 实例对象
     * @return 影响行数
     */
    int update(Answer answer);

    /**
     * 通过主键删除数据
     *
     * @param answerid 主键
     * @return 影响行数
     */
    int deleteById(Integer answerid);

}