package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@ApiModel("department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * did
     */
    @ApiModelProperty("did")
    private Long id;

    /**
     * hid
     */
    @ApiModelProperty("hid")
    private Long hospitalId;

    /**
     * 科室名
     */
    @ApiModelProperty("科室名")
    private String departmentName;

    /**
     * 父did
     */
    @ApiModelProperty("父did")
    private Long parentId;
}