package com.example.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Account {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("收入")
    private Double balance;

}
