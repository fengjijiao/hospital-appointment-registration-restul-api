package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Scheduling implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 科室id
     */
    private Long departmentId;

    /**
     * 排班日期
     */
    private Date date;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 入库时间
     */
    private Date addTime;

    /**
     * 排班状态，0:未完成;1:已完成
     */
    private Integer schedulingStatus;


    public Scheduling() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getSchedulingStatus() {
        return schedulingStatus;
    }

    public void setSchedulingStatus(Integer schedulingStatus) {
        this.schedulingStatus = schedulingStatus;
    }

}