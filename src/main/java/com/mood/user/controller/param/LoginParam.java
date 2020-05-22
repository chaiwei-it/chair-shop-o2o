package com.mood.user.controller.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户模块
 * @author fenglu
 * @time 2018-06-06 15:16
 */
@Data
@ApiModel
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"},ignoreUnknown = true)
public class LoginParam implements Serializable {

    @NotBlank(message = "请输入密码")
    @NotNull(message = "请输入密码")
    @ApiModelProperty(value="用户密码",name="password",example="123456")
    private String password;

    @NotBlank(message = "请输入手机号码")
    @NotNull(message = "请输入手机号码")
    private String username;

}
