package org.dromara.wemq.framework.config;

import org.dromara.wemq.framework.interceptor.LoginInterceptor;
import org.dromara.wemq.framework.interceptor.RepeatSubmitInterceptor;
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
                .excludePathPatterns("/statics/**", "/dologin", "/login", "/mq/**", "/error/**","/static/**");

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
