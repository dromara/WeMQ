package org.dromara.common.enums;

/**
 * 状态码
 * @author NicholasLD
 * @createTime 2023/4/3 16:57
 */
public enum HttpStatus {
    OK(200, "成功"),
    FAIL(0,"失败"),
    COMMON_EXCEPTION(500, "系统异常"),

    // 1xxx 用户相关
    USER_NOT_EXIST(1001, "用户不存在"),
    USER_NOT_LOGIN(1002, "用户未登录"),
    USER_NOT_AUTH(1003, "用户未授权"),
    USER_NOT_PERMISSION(1004, "用户无权限"),
    USER_NOT_EXIST_OR_PASSWORD_ERROR(1005, "用户名或密码错误"),

    // 2xxx 业务相关
    BUSINESS_EXCEPTION(2001, "业务异常"),
    BUSINESS_NOT_EXIST(2002, "业务不存在"),
    BUSINESS_NOT_AUTH(2003, "业务未授权"),

    // 3xxx 系统相关
    REPEAT_SUBMIT(3001, "重复提交");


    private final int value;
    private final String message;

    HttpStatus(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getCode() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public static HttpStatus valueOf(int value) {
        for (HttpStatus httpStatus : values()) {
            if (httpStatus.value == value) {
                return httpStatus;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
    }


}
