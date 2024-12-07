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

import static com.medium.CONSTANTS.ENV.*;
import static com.medium.CONSTANTS.ENV.PROPERTY_SHOW_SQL;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.medium.repository")
@ComponentScan({ "com.medium.Config" })
public class SpringDataJPAConfig {

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.medium.Model");
        localContainerEntityManagerFactoryBean.setJpaProperties(hibernateProps());

        return localContainerEntityManagerFactoryBean;
    }


    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setUrl(DB_URL.value);
        driverManagerDataSource.setUsername(DB_USERNAME.value);
        driverManagerDataSource.setPassword(DB_PASSWORD.value);
        driverManagerDataSource.setDriverClassName(DB_DRIVER_CLASS_NAME.value);

        return driverManagerDataSource;
    }

    Properties hibernateProps() {
        Properties properties = new Properties();

        properties.setProperty(PROPERTY_DIALECT.value,DB_DIALECT.value);
        properties.setProperty(PROPERTY_SHOW_SQL.value,DB_SHOW_SQL.value);

        return properties;
    }

    @Bean
    JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
