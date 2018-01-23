package mybatis.spring.main;

import mybatis.spring.main.app.entity.Human;
import mybatis.spring.main.app.service.HumanService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan()
@MapperScan(basePackages = {"mybatis.spring.main.app.mapper"},sqlSessionFactoryRef = "sqlSessionFactory")
@PropertySources({@PropertySource("classpath:application-jdbc.properties")})
public class SpringWeb1 /*implements EmbeddedServletContainerCustomizer*/{

    @Autowired
    HumanService humanService;

    public static Log log=LogFactory.getLog(SpringWeb1.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Human sayHello(){

        Human human=humanService.getHumanById(1);
        log.info("《》《》《》《"+human+"》》《》《》《》《《》");
        System.out.println(human);
        return human;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringWeb1.class);
    }

//    @Override
//    public void customize(ConfigurableEmbeddedServletContainer container) {
//        container.setPort(81);
//    }
//    @Bean
//    public TomcatEmbeddedServletContainerFactory servletContainer(){
//        TomcatEmbeddedServletContainerFactory factory=new TomcatEmbeddedServletContainerFactory();
//        factory.setPort(8089);
//        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/notFound.html"));
//        return factory;
//    }

//    @Bean(value = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception{
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(
//                resolver.getResources("classpath:/mapper/*.xml")
//        );
//        return sqlSessionFactoryBean.getObject();
//    }
////
    @Bean
    @Scope(value = "prototype")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer(){
//        TomcatEmbeddedServletContainerFactory t=new TomcatEmbeddedServletContainerFactory();
//        t.addAdditionalTomcatConnectors(createContainer());
//        return t;
//    }
//
//    private Connector createContainer() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//        try {
//            File keystore = new ClassPathResource("keystore").getFile();
//            File truststore = new ClassPathResource("keystore").getFile();
//            connector.setScheme("https");
//            connector.setSecure(true);
//            connector.setPort(8444);
//            protocol.setSSLEnabled(true);
//            protocol.setKeystoreFile(keystore.getAbsolutePath());
//            protocol.setKeystorePass("changeit");
//            protocol.setTruststoreFile(truststore.getAbsolutePath());
//            protocol.setTruststorePass("changeit");
//            protocol.setKeyAlias("apitester");
//            return connector;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return connector;
//    }
}
