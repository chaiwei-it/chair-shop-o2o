package com.chair.user.service.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户模块
 * @author fenglu
 * @time 2018-06-06 17:06
 */
@Data
public class LoginVO  {



    @ApiModelProperty(value = "token", example = "1", required = true)
    private String token;

    @ApiModelProperty(value = "userInfo", example = "1", required = true)
    private AdminInfo adminInfo;
}
