package com.chair.base;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-06-04 下午16:00
 */
public enum StateCode {
    /**
     * 用于登录时用户不存在的情况
     */
    SUCCESS(200, "success"),
    /**
     * 用于登录时用户不存在的情况
     */
    COMMON_ACCOUNT_ERROR(401, "账号未登陆"),
    /**
     * 用于登录时用户不存在的情况
     */
    SYSTEM_UNKNOWN_ERROR(1, "系统繁忙，请稍后再试...."),
    /**
     * 用于登录时用户不存在的情况
     */
    COMMON_PARAM_EMPTY(2, "必选参数为空"),

    /**
     * 用于登录时用户不存在的情况
     */
    USER_NOT_EXISTS(42003, "用户不存在, 请先注册"),

    /**
     * 凭证错误
     */
    INVALID_CREDENTIAL(42004, "用户名或密码错误"),







    ;

    private int code;
    private String message;

    StateCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "StateCodeEnum{" + "code='" + code + '\'' + ", message='" + message + '\'' + '}';
    }

}
