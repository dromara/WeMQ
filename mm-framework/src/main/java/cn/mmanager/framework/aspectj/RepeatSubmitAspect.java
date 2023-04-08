package cn.mmanager.framework.aspectj;

import cn.mmanager.common.annotation.RepeatSubmit;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.framework.utils.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 防止重复提交注解切面
 * @author NicholasLD
 * @createTime 2023/4/3 13:06
 */
@Aspect
@Component
public class RepeatSubmitAspect {
    private static final Logger logger = LoggerFactory.getLogger(RepeatSubmitAspect.class);

    // 配置织入点
    @Pointcut("@annotation(cn.mmanager.common.annotation.RepeatSubmit)")
    public void repeatSubmitPointCut() {
    }

    @Before("repeatSubmitPointCut()")
    public void doBefore() {
        logger.info("[防重复提交] 介入切面，开始检测重复提交");
    }
}
