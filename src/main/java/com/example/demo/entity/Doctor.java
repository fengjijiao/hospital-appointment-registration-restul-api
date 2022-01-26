package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@ApiModel("doctor")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

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
    private Long departmentId;

    /**
     * 医生职称
     */
    @ApiModelProperty("医生职称")
    private Integer doctorJobTitle;

    /**
     * 医生状态，0:正常;1:~
     */
    @ApiModelProperty("医生状态，0:正常;1:~")
    private Integer doctorStatus;
}