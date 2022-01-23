package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * did
     */
    @ApiModelProperty("did")
    private Integer id;

    /**
     * hid
     */
    @ApiModelProperty("hid")
    private Integer hospitalId;

    /**
     * 科室名
     */
    @ApiModelProperty("科室名")
    private String departmentName;

    /**
     * 父did
     */
    @ApiModelProperty("父did")
    private Integer parentId;

    public Department() {}
}