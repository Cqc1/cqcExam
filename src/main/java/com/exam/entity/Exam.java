package com.exam.entity;

import java.io.Serializable;

/**
 * (Exam)实体类
 *
 * @author chenqiancheng
 * @since 2020-03-24 00:07:12
 */
public class Exam implements Serializable {
    private static final long serialVersionUID = 681318088697793865L;
    /**
    * 考试编号
    */
    private Integer examid;
    /**
    * 试卷编号
    */
    private Integer paperid;
    /**
    * 课程编号
    */
    private Integer courseid;
    /**
    * 考生学号
    */
    private Integer stuid;
    /**
    * 年级
    */
    private String grade;
    /**
    * 学期
    */
    private String term;
    /**
    * 专业
    */
    private String major;
    /**
    * 学院
    */
    private String institution;
    /**
    * 考试时长
    */
    private Integer extime;
    /**
    * 考试地点
    */
    private String explace;
    /**
    * 考试日期
    */
    private String exdate;
    /**
    * 考试描述
    */
    private String description;
    /**
    * 是否已考
    */
    private String isexam;


    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Integer getExtime() {
        return extime;
    }

    public void setExtime(Integer extime) {
        this.extime = extime;
    }

    public String getExplace() {
        return explace;
    }

    public void setExplace(String explace) {
        this.explace = explace;
    }

    public String getExdate() {
        return exdate;
    }

    public void setExdate(String exdate) {
        this.exdate = exdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsexam() {
        return isexam;
    }

    public void setIsexam(String isexam) {
        this.isexam = isexam;
    }

}