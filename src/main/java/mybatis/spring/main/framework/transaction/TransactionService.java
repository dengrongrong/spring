package mybatis.spring.main.framework.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement()
public class TransactionService {

    @Resource
    DataSource dataSource;

    @Bean(value = "tx")
    public PlatformTransactionManager getTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }
}
