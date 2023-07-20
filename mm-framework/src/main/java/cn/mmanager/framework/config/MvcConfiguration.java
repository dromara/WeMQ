package cn.mmanager.framework.config;

import cn.mmanager.framework.aspectj.RepeatSubmitAspect;
import cn.mmanager.framework.interceptor.LoginInterceptor;
import cn.mmanager.framework.interceptor.RepeatSubmitInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author NicholasLD
 * @createTime 2023/6/19 00:18
 */
@EnableAspectJAutoProxy
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置LoginInterceptor拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/statics/**", "/dologin", "/login", "/pages/**", "/error/**","/static/**");

        // 配置RepeatSubmitInterceptor拦截器
        registry.addInterceptor(new RepeatSubmitInterceptor())
                .addPathPatterns("/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**")
                .addResourceLocations("classpath:/static/");
    }
}
