package com.qiandao.model;

import java.util.List;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/11/1 23:33
 */
public class StudyPlanQuery {
    private Long studentId;
    private Long lessonId;
    private Long courseStartTime;
    private Long courseEndTime;
    private Integer limit;
    private Integer courseType;
    private Integer status;
    private Integer type;
    private List<Integer> typeIgnoredList;

    public Long getStudentId() {
        return studentId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public Long getCourseStartTime() {
        return courseStartTime;
    }

    public Long getCourseEndTime() {
        return courseEndTime;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getType() {
        return type;
    }

    public List<Integer> getTypeIgnoredList() {
        return typeIgnoredList;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public void setCourseStartTime(Long courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public void setCourseEndTime(Long courseEndTime) {
        this.courseEndTime = courseEndTime;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setTypeIgnoredList(List<Integer> typeIgnoredList) {
        this.typeIgnoredList = typeIgnoredList;
    }
}
