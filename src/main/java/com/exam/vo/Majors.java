package com.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Majors {
    private static final long serialVersionUID = -37943108635836852L;
    /**
     * 专业编号
     */
    private Integer majorid;
    /**
     * 专业名称
     */
    private String major;
}
