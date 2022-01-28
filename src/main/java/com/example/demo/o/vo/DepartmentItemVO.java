package com.example.demo.o.vo;

import com.example.demo.entity.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString
@Data
public class DepartmentItemVO extends Department {
    /**
     * 二级科室
     */
    private ResultT<List<Department>> subClass;

    public DepartmentItemVO(ResultT<List<Department>> subClassDepartmentList) {
        this.subClass = subClassDepartmentList;
    }

    /**
     * 更新部门信息到本类
     * @param department
     */
    public void updateDepartmentInfo(Department department) {
        this.setId(department.getId());
        this.setDepartmentName(department.getDepartmentName());
        this.setParentId(department.getParentId());
        this.setHospitalId(department.getHospitalId());
    }
}
