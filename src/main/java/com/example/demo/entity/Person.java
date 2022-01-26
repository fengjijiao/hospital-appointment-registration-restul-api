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
     * uid
     */
    @ApiModelProperty("uid")
    private Long id;

    /**
     * username
     */
    @ApiModelProperty("user_name")
    private String userName;

    /**
     * user_age
     */
    @ApiModelProperty("user_age")
    private Integer userAge;

    /**
     * mobile
     */
    @ApiModelProperty("mobile")
    private String mobile;

    /**
     * sex
     */
    @ApiModelProperty("sex")
    private String sex;

    /**
     * id_card_no
     */
    @ApiModelProperty("id_card_no")
    private String idCardNo;

    /**
     * open_id
     */
    @ApiModelProperty("open_id")
    private String openId;
}