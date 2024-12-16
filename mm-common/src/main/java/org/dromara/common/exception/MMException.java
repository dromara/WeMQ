package org.dromara.common.exception;

import org.dromara.common.enums.HttpStatus;

/**
 * 自定义异常
 * @author NicholasLD
 * @createTime 2023/4/3 17:03
 */
public class MMException extends RuntimeException{
    private Integer code; // 错误码
    private String message; // 错误信息

    public MMException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public MMException(HttpStatus httpStatus) {
        this.code = httpStatus.getCode();
        this.message = httpStatus.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
