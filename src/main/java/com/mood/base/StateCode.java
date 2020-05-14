package com.mood.base;

/**
 * Created by shihan on 2020/1/8.
 */
public enum StateCode {

    SUCCESS(200, "success"),

    COMMON_ACCOUNT_ERROR(401, "账号未登陆"),

    SYSTEM_UNKNOWN_ERROR(1, "系统繁忙，请稍后再试...."),

    COMMON_PARAM_EMPTY(2, "必选参数为空"),







    ;

    private int code;
    private String desc;

    StateCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "StateCodeEnum{" + "code='" + code + '\'' + ", desc='" + desc + '\'' + '}';
    }

}
