package cn.mmanager.framework.interceptor;

import cn.mmanager.common.constant.UserConstants;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author NicholasLD
 * @createTime 2023/4/3 10:55
 */
public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = org.slf4j.LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("拦截器拦截到请求：{}", request.getRequestURI());

        if(request.getRequestURI().equals("/login") || request.getRequestURI().equals("/dologin")){
            //判断用户是否已经登录
            if (request.getSession().getAttribute(UserConstants.USER_SESSION) != null) {
                logger.info("[登录] 用户已登录，跳转到主页");
                response.sendRedirect("/");
                return false;
            }
            return true;
        }

        if (request.getRequestURI().equals("/logout")) {
            //判断用户是否已经登录
            if (request.getSession().getAttribute(UserConstants.USER_SESSION) != null) {
                logger.info("[注销] 用户已登录，放行");
                return true;
            }
            response.sendRedirect("/login");
            return false;
        }

        // 判断session中是否有用户信息
        if (request.getSession().getAttribute(UserConstants.USER_SESSION) == null) {
            logger.info("用户未登录，跳转到登录页面");
            response.sendRedirect("/login?redirect="+request.getRequestURI());
            return false;
        }

        // 已登录，放行
        return true;
    }
}
