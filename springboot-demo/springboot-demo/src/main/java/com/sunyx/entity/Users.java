package com.sunyx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Users对象", description="")
public class Users {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;


    @ApiModelProperty(value = "用户名")
    private String username;


    @ApiModelProperty(value = "电话号")
    private String phone;


    @ApiModelProperty(value = "密码")
    private String password;
}
