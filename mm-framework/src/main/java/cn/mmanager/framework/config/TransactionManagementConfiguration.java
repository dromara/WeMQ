package cn.mmanager.framework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author NicholasLD
 * @createTime 2023/6/19 00:17
 */
@Configuration
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer {
    @Autowired
    private TransactionManager transactionManager;

    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return transactionManager;
    }
}
