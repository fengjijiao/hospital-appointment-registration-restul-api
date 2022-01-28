package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@ApiModel("person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer userAge;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;

    /**
     * 卡号
     */
    @ApiModelProperty("卡号")
    private String idCardNo;

    /**
     * open_id
     */
    @ApiModelProperty("open_id")
    private String openId;
}