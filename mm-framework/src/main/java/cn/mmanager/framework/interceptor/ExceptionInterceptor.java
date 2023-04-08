package cn.mmanager.framework.interceptor;

import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.exception.MMException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
