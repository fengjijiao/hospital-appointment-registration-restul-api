package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("doctor")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 医生姓名
     */
    @ApiModelProperty("医生姓名")
    private String doctorName;

    /**
     * doctor_sex
     */
    @ApiModelProperty("doctor_sex")
    private String doctorSex;

    /**
     * did
     */
    @ApiModelProperty("did")
    private Integer departmentId;

    /**
     * 医生职称
     */
    @ApiModelProperty("医生职称")
    private int doctorJobTitle;

    /**
     * 医生状态，0:正常;1:~
     */
    @ApiModelProperty("医生状态，0:正常;1:~")
    private int doctorStatus;

    public Doctor() {
    }
}