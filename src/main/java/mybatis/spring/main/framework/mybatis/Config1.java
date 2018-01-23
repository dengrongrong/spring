package mybatis.spring.main.framework.mybatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class Config1 {

    public static Log log= LogFactory.getLog(Config1.class);

    @Bean(value = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource ds)
            throws Exception {

        log.info("<<*************************init sqlSessionFactory*****************************>>");
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds);
        log.info("<<-----------------------set mybatis config----------------------------->>");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        log.info("<<---------------------------mybatis config"+"\n"+"---------------------------->>");
        SqlSessionFactory sqlSessionFactory=sessionFactory.getObject();
        log.info("<<**************************init sqlSessionFactory success:"+ds+"\n"
                +"\n"+"*****************************>>");
        return sqlSessionFactory;
    }

    @Bean(name="dataSource")
    public DataSource initDataSource(DataSourceProps ds){
        log.info("<<---------------init PooledDataSource---------------->>");
        PooledDataSource pool=new PooledDataSource();
        pool.setDriver(ds.getDriver());
        pool.setUrl(ds.getUrl());
        pool.setPassword(ds.getPassword());
        pool.setUsername(ds.user);
        pool.setPoolMaximumCheckoutTime(ds.getMaxCheckOutTime());
        pool.setPoolTimeToWait(ds.getTimeToWait());
        pool.setPoolMaximumActiveConnections(ds.getMaxActive());
        pool.setPoolMaximumIdleConnections(ds.getMaxIdle());
        System.out.println(ds);
        return pool;
    }

    @ConfigurationProperties(prefix = "ds")
    @Component("ds")
    public  static class DataSourceProps{

        public String driver;
        public String user;
        public String url;
        public String password;
        public int timeToWait;
        public int maxCheckOutTime;
        public int maxActive;
        public int maxIdle;
        @Override
        public String toString() {
            return "DataSourceProps{" +
                    "driver='" + driver + '\'' +
                    ", user='" + user + '\'' +
                    ", url='" + url + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getTimeToWait() {
            return timeToWait;
        }

        public void setTimeToWait(int timeToWait) {
            this.timeToWait = timeToWait;
        }

        public int getMaxCheckOutTime() {
            return maxCheckOutTime;
        }

        public void setMaxCheckOutTime(int maxCheckOutTime) {
            this.maxCheckOutTime = maxCheckOutTime;
        }

        public int getMaxActive() {
            return maxActive;
        }

        public void setMaxActive(int maxActive) {
            this.maxActive = maxActive;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }
    }

}
