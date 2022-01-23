package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("排班员工")
public class SchedulingStuff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 医生id
     */
    @ApiModelProperty("医生id")
    private Integer doctorId;

    /**
     * 排班id
     */
    @ApiModelProperty("排班id")
    private Integer schedulingId;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endTime;

    /**
     * 入库时间
     */
    @ApiModelProperty("入库时间")
    private Date addTime;

    /**
     * 科室id
     */
    @ApiModelProperty("科室id")
    private Integer departmentId;

    /**
     * 排班日期
     */
    @ApiModelProperty("排班日期")
    private Date date;

    /**
    * 排班状态，0:未完成;1:已完成
    */
    @ApiModelProperty("排班状态，0:未完成;1:已完成")
    private int schedulingStatus;

    public SchedulingStuff() {
    }
}