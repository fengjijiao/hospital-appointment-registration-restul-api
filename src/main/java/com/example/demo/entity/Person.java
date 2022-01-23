package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

@Data
@ApiModel("person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * uid
     */
    @ApiModelProperty("uid")
    private Integer id;

    /**
     * username
     */
    @ApiModelProperty("username")
    private String username;

    /**
     * user_age
     */
    @ApiModelProperty("user_age")
    private int userAge;

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

    public Person() {}
}