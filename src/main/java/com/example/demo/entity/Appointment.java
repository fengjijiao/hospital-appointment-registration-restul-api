package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Accessors(chain = true)
@Data
@ApiModel("appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 科室id
     */
    @ApiModelProperty("科室id")
    private Long departmentId;

    /**
     * 预约时间
     */
    @ApiModelProperty("预约时间")
    private Long time;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;

    /**
     * 入库时间
     */
    @ApiModelProperty("入库时间")
    private Date addTime;

    /**
     * 医生id
     */
    @ApiModelProperty("医生id")
    private Long doctorId;
}