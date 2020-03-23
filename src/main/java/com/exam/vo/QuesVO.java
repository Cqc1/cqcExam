package com.exam.vo;

import com.exam.entity.Course;
import lombok.Data;

@Data
public class QuesVO {
    private Integer quesid;
    private String question;
    private String couname;
    private String score;
    private String chapter;
    private String level;
    private String type;
    private String questype;
    private Integer courseid;
    private Course course;
}
