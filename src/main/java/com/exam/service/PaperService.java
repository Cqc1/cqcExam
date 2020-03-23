package com.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Paper;

import java.util.List;

/**
 * (Paper)表服务接口
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
public interface PaperService {

    /**
     * 分页查询所有试卷
     * @param page
     * @return List<Paper>
     */
    IPage<Paper> findAll(Page page);

    Paper findById(Integer paperid);

    //通过试卷id来查找详细信息
    Paper findBypaperidDet(Integer paperid);

    //通过课程编号来查询
    List<Paper> findByCourse(Integer courseid);

    //通过组卷人来进行查询
    List<Paper> findByUser(String user);

    int deletebyId(Integer paperid);

    /**
     *更新所有试卷信息
     * @param paper 传递一个对象
     * @return 受影响的记录条数
     */
    int updatePaper(Paper paper);

    int add(Paper paper);

    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     * @return paperId
     */
    Paper findOnlyPaperId();
}