package com.anona.parkour.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "cz.anona.parkour.repositories.cookies", transactionManagerRef = "jpaTransactionManagerCookies")
public class CookiesConfig {

    @Autowired
    private Environment env;

    @Bean(name = "dataSourceCookies")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("database-cookies.datasource.driver-class-name")));
        dataSource.setUrl(env.getProperty("database-cookies.datasource.url"));
        dataSource.setUsername(env.getProperty("database-cookies.datasource.username"));
        dataSource.setPassword(env.getProperty("database-cookies.datasource.password"));
        return dataSource;
    }

    @Bean(name = "entityManagerFactoryCookies")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSourceCookies") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("cz.anona.parkour.entities.cookies")
                .persistenceUnit("sessionCookiePersistenceUnit").build();
    }

    @Bean(name = "jpaTransactionManagerCookies")
    public JpaTransactionManager jpaTransactionManager(
            @Qualifier("entityManagerFactoryCookies") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.show_sql", true);
        hibernateProperties.put("spring.jpa.generate-ddl", true);
        jpaTransactionManager.setJpaProperties(hibernateProperties);
        return jpaTransactionManager;
    }


}
