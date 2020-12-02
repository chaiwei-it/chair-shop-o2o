package com.chair.user.service.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户模块
 * @author fenglu
 * @time 2018-06-06 15:16
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"},ignoreUnknown = true)
public class LoginCommand implements Serializable {

    @NotEmpty(message = "请输入密码")
    private String password;

    @NotEmpty(message = "请输入手机号码")
    private String username;

}
