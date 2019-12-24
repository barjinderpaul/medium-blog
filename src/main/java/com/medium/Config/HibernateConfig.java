package com.medium.Config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.medium.Config" })
@PropertySource(value = { "classpath:database.properties" })
public class HibernateConfig {
    private final String PROPERTY_DRIVER = "driver";
    private final String PROPERTY_URL = "url";
    private final String PROPERTY_USERNAME = "user";
    private final String PROPERTY_PASSWORD = "password";
    private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
    private final String PROPERTY_DIALECT = "hibernate.dialect";

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.medium.Model" });
        sessionFactory.setHibernateProperties(hibernateProps());

        return sessionFactory;
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/medium");
        ds.setUsername("postgres");
        ds.setPassword("123456");
        ds.setDriverClassName("org.postgresql.Driver");
        return ds;
    }

    Properties hibernateProps() {
        Properties properties = new Properties();
        properties.setProperty(PROPERTY_DIALECT,"org.hibernate.dialect.PostgreSQL82Dialect");
        properties.setProperty(PROPERTY_SHOW_SQL,"true");
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
