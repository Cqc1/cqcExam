package com.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author chenqiancheng
 * @since 2020-03-12 20:53:27
 */
@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {

    /**
     * 分页查询所有教师
     * @param page
     * @return List<Teacher>
     */
    @Select("select * from teacher")
    IPage<Teacher> findAll(Page page);

    @Select("select * from teacher where teaId = #{teaid}")
    Teacher findById(Integer teacherId);

    @Select("select * from teacher where teaName = #{teaname}")
    List<Teacher> findByName(String teacherName);

    @Delete("delete from teacher where teaId = #{teaid}")
    int deletebyId(Integer teacherId);

    /**
     *更新所有教师信息
     * @param teacher 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update teacher set teaName = #{teaname},sex = #{sex}," +
            "tel = #{tel}, email = #{email},teaPwd = #{teapwd}," +
            "role = #{role},yuanName = #{yuanname},role = #{role} where teaId = #{teaid}")
    int updateTea(Teacher teacher);

    /**
     * 更新密码
     * @param teacher
     * @return 受影响的记录条数
     */
    @Update("update teacher set teaPwd = #{teapwd} where teaId = #{teaid}")
    int updatePwd(Teacher teacher);


    @Options(useGeneratedKeys = true,keyProperty = "teaid")
    @Insert("insert into teacher(teaName,sex,tel,email,teaPwd,role,yuanName) " +
            "values(#{teaname},#{sex},#{tel},#{email},#{teapwd},#{role},#{yuanname})")
    int add(Teacher teacher);

}