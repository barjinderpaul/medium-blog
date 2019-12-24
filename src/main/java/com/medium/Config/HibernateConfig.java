package com.medium.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.medium.repository")
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
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
        lfb.setDataSource(dataSource());
        lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lfb.setPackagesToScan("com.medium.Model");
        lfb.setJpaProperties(hibernateProps());
        return lfb;
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
    JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
