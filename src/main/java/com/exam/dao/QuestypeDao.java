package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Questype;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Questype)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-19 23:55:34
 */
public interface QuestypeDao {

    /**
     * 分页查询所有试题类型
     * @param page
     * @return List<Questype>
     */
    @Select("select * from questype")
    IPage<Questype> findAll(Page page);
    //不分页查询
    @Select("select * from questype")
    List<Questype> findAllInfo();

    @Select("select * from questype where quesType = #{questype}")
    Questype findById(Integer questype);

    @Select("select * from questype where quesName = #{quesname}")
    List<Questype> findByName(String quesname);

    @Delete("delete from questype where quesType = #{questype}")
    int deletebyId(Integer questype);

    /**
     *更新所有试题类型信息
     * @param questype 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update questype set quesName = #{quesname}" +
            "where quesType = #{questype}")
    int updateQuty(Questype questype);

    @Options(useGeneratedKeys = true,keyProperty = "questype")
    @Insert("insert into questype(quesName) values " +
            "(#{quesname})")
    int add(Questype questype);
}