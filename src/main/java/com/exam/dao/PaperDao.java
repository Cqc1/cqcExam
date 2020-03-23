package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Paper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Paper)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface PaperDao extends BaseMapper<Paper> {

    /**
     * 分页查询所有试卷
     * @param page
     * @return List<Paper>
     */
//    @Select("select * from paper")
    IPage<Paper> findAll(Page page);

//    @Select("select * from paper where paperId = #{paperid}")
    Paper findById(Integer paperid);

    //通过试卷id来查找详细信息
    Paper findBypaperidDet(Integer paperid);
    //通过课程编号来查询
//    @Select("select * from paper where courseId = #{courseid}")
    List<Paper> findByCourse(Integer courseid);

    //通过组卷人来进行查询
//    @Select("select * from paper where user = #{user}")
    List<Paper> findByUser(String user);

    @Delete("delete from paper where paperId = #{paperid}")
    int deletebyId(Integer paperid);

    /**
     *更新所有试卷信息
     * @param paper 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update paper set paperId=#{paperid},courseId = #{courseid},totalScore = #{totalscore},user = #{user}, " +
            "description = #{description} " +
            "where paperId = #{paperid}")
    int updatePaper(Paper paper);

    @Options(useGeneratedKeys = true,keyProperty = "paperid")
    @Insert("insert into paper(courseId,totalScore,user,description) values " +
            "(#{courseid},#{totalscore},#{user},#{description})")
    int add(Paper paper);

    /**
     * 查询最后一条记录的paperId,返回给前端达到自增效果
     * @return paperId
     */
    @Select("select paperId from paper order by paperId desc limit 1")
    Paper findOnlyPaperId();

}