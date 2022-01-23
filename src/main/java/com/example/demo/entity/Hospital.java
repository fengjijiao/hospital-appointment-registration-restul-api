package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("hospital")
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * hid
     */
    @ApiModelProperty("hid")
    private Integer id;

    /**
     * hospital_name
     */
    @ApiModelProperty("hospital_name")
    private String hospitalName;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String hospitalContact;

    /**
     * hospital_level
     */
    @ApiModelProperty("hospital_level")
    private String hospitalLevel;

    /**
     * 分支类型，1:总院;2:分院
     */
    @ApiModelProperty("分支类型，1:总院;2:分院")
    private int hospitalBranchType;

    /**
     * hospital_introduction
     */
    @ApiModelProperty("hospital_introduction")
    private String hospitalIntroduction;

    /**
     * 总院id
     */
    @ApiModelProperty("总院id")
    private Integer hospitalParentId;

    public Hospital() {}
}