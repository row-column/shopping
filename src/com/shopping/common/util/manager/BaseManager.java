package com.shopping.common.util.manager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * manager����
 * User: YinWei
 * Date: 2011-8-3
 * Time: 17:31:19
 */
public class BaseManager {
    private PlatformTransactionManager transactionManager;

    public TransactionTemplate getDataSourceTransactionManager() {
        return new TransactionTemplate(transactionManager);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}

