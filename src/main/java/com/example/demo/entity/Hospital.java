package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@ApiModel("hospital")
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 医院ID
     */
    @ApiModelProperty("医院ID")
    private Integer id;

    /**
     * 医院名称
     */
    @ApiModelProperty("医院名称")
    private String hospitalName;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String hospitalContact;

    /**
     * 医院等级
     */
    @ApiModelProperty("医院等级")
    private String hospitalLevel;

    /**
     * 分支类型，1:总院;2:分院
     */
    @ApiModelProperty("分支类型，1:总院;2:分院")
    private Integer hospitalBranchType;

    /**
     * 医院介绍
     */
    @ApiModelProperty("医院介绍")
    private String hospitalIntroduction;

    /**
     * 总院id
     */
    @ApiModelProperty("总院id")
    private Long hospitalParentId;
}