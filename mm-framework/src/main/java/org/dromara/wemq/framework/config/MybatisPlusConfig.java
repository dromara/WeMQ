package org.dromara.wemq.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author NicholasLD
 * @date 2024/12/16
 */
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("org.dromara.wemq.mapper")
public class MybatisPlusConfig {

}
