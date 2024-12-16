package org.dromara.wemq.framework.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    @Pointcut("@annotation(org.dromara.wemq.common.annotation.RepeatSubmit)")
    public void repeatSubmitPointCut() {
    }

    @Before("repeatSubmitPointCut()")
    public void doBefore() {
        logger.info("[防重复提交] 介入切面，开始检测重复提交");
    }
}
