package org.dromara.framework.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.dromara.common.annotation.RepeatSubmit;
import org.dromara.common.enums.HttpStatus;
import org.dromara.common.exception.MMException;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 防止重复提交拦截器
 * @author NicholasLD
 * @createTime 2023/4/3 13:11
 */
@Component
public class RepeatSubmitInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RepeatSubmitInterceptor.class);
    public final String REPEAT_PARAMS = "repeatParams";
    public final String REPEAT_TIME = "repeatTime";
    public final String SESSION_REPEAT_KEY = "repeatData";
    private static final com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
    private static final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if (annotation != null) {
                if (this.isRepeatSubmit(request, annotation)) {
                    logger.info("[防重复提交] 检测到重复提交请求：" + request.getRequestURI());
                    throw new MMException(HttpStatus.REPEAT_SUBMIT);
                }
            }
        }
        return true;
    }

    public boolean isRepeatSubmit(HttpServletRequest request, RepeatSubmit annotation) throws Exception {
        // 本次参数及系统时间
        String nowParams = objectWriter.writeValueAsString(request.getParameterMap());
        Map<String, Object> nowDataMap = new HashMap<>();
        nowDataMap.put(REPEAT_PARAMS, nowParams);
        nowDataMap.put(REPEAT_TIME, System.currentTimeMillis());

        // 请求地址（作为存放session的key值）
        String url = request.getRequestURI();

        HttpSession session = request.getSession();
        Object sessionObj = session.getAttribute(SESSION_REPEAT_KEY);
        if (sessionObj != null) {
            Map<String, Object> sessionMap = (Map<String, Object>) sessionObj;
            if (sessionMap.containsKey(url)) {
                Map<String, Object> preDataMap = (Map<String, Object>) sessionMap.get(url);
                if (compareParams(nowDataMap, preDataMap) && compareTime(nowDataMap, preDataMap, annotation.interval())) {
                    return true;
                }
            }
        }
        Map<String, Object> sessionMap = new HashMap<>();
        sessionMap.put(url, nowDataMap);
        session.setAttribute(SESSION_REPEAT_KEY, sessionMap);
        return false;
    }

    /**
     * 判断参数是否相同
     */
    private boolean compareParams(Map<String, Object> nowMap, Map<String, Object> preMap) {
        String nowParams = (String) nowMap.get(REPEAT_PARAMS);
        String preParams = (String) preMap.get(REPEAT_PARAMS);
        return nowParams.equals(preParams);
    }

    /**
     * 判断两次间隔时间
     */
    private boolean compareTime(Map<String, Object> nowMap, Map<String, Object> preMap, int interval) {
        long time1 = (Long) nowMap.get(REPEAT_TIME);
        long time2 = (Long) preMap.get(REPEAT_TIME);
        if ((time1 - time2) < interval) {
            return true;
        }
        return false;
    }
}
