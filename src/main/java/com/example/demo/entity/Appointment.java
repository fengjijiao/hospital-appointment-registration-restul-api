package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 科室id
     */
    @ApiModelProperty("科室id")
    private Integer departmentId;

    /**
     * 预约时间
     */
    @ApiModelProperty("预约时间")
    private Integer time;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private int status;

    /**
     * 入库时间
     */
    @ApiModelProperty("入库时间")
    private Date addTime;

    /**
     * 医生id
     */
    @ApiModelProperty("医生id")
    private Integer doctorId;

    public Appointment() {
    }
}