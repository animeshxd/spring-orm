package io.github.animeshxd;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "io.github.animeshxd.repository")
public class AppConfig {

    @Bean
    public HibernateTemplate template(){
        return new HibernateTemplate(sessionFactory().getObject());
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource()); // required
        sessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        sessionFactory.setPackagesToScan("io.github.animeshxd.models"); // scan entities
        return sessionFactory;
    }
    // this Datasource bean is required, we can't specify connection configs in hibernate.cfg.xml
    // spring is one to configure datasource
    @Bean
    public DataSource dataSource(){
        var dataSource = new DriverManagerDataSource("jdbc:postgresql:test", "test", "test");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    HibernateTransactionManager transactionManager(){
        var transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject()); 
        return transactionManager;
    }
}
