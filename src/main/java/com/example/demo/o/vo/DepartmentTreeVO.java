package com.example.demo.o.vo;

import lombok.*;

import java.util.List;

@Data
public class DepartmentTreeVO {
    /**
     * 一级科室
     */
    private List<DepartmentItemVO> data;
    /**
     * 一级科室列表长度
     */
    private int length;

    public DepartmentTreeVO(List<DepartmentItemVO> departmentList) {
        this.data = departmentList;
        this.length = departmentList.size();
    }
}

