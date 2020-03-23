package com.exam.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.vo.QuesVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuesDao {
//    @Select("select question, course.couname, score, chapter,level, \"单项选择题\" as type from sing_ques " +
//            "union select  course.couname,  score, chapter,level, \"多项选择题\" as type  from mult_ques " +
//            "union select  course.couname,  score, chapter,level, \"填空题\" as type from fill_ques " +
//            "union select  course.couname,  score, chapter,level, \"判断题\" as type  from judge_ques " +
//            "union select  course.couname,  score, chapter,level, \"简答题\" as type  from short_ques "
//    )
    //分页查询所有试题信息
    IPage<QuesVO> findAll(Page page);

    //按条件(题目信息和题目类型)查找
    List<QuesVO> findByQues(String question,String questype);

    //按题目类型进行查询
    List<QuesVO> findByType(String questype);

    //按题目所属科目进行查询
    List<QuesVO> findByCourse(Integer courseid);

}
