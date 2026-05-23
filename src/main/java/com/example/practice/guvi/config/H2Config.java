package com.example.practice.guvi.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.practice.guvi.repository.h2", // Where H2 repos live
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager"
)
public class H2Config {

//    @Bean(name = "h2DataSource")
//    @ConfigurationProperties(prefix = "app.datasource.h2")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
    @Bean(name = "h2DataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:analytics_db;DB_CLOSE_DELAY=-1") // Or bind dynamically using @Value
                .username("sa")
                .password("")
                .driverClassName("org.h2.Driver")
                .build();
    }

    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("h2DataSource") DataSource dataSource) {
        // Explicitly force H2 Hibernate properties so it doesn't use MySQL rules
        Map<String, Object> h2Properties = new HashMap<>();
        h2Properties.put("hibernate.hbm2ddl.auto", "update");
        h2Properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return builder
                .dataSource(dataSource)
                .packages("com.example.practice.guvi.model.h2") // Where H2 entities live
                .persistenceUnit("h2")
                .properties(h2Properties)
                .build();
    }

    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("h2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
