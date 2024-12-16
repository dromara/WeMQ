package org.dromara.framework.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dromara.common.core.domain.AjaxResult;
import org.dromara.common.exception.MMException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author NicholasLD
 * @createTime 2023/4/3 17:08
 */
@ControllerAdvice
public class ExceptionInterceptor {
    @ResponseBody
    @ExceptionHandler(MMException.class)
    public AjaxResult processQYException(Throwable cause, HttpServletRequest request, HttpServletResponse response){
        MMException mmException = null;
        if(cause instanceof MMException){
            mmException = (MMException) cause;
        }
        if (mmException != null) {
            return new AjaxResult(mmException.getCode(),mmException.getMessage());
        }
        return AjaxResult.error("未知错误");
    }
}
