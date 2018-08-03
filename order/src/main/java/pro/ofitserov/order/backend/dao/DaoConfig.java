package pro.ofitserov.order.backend.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DaoConfig {

    @Bean
    @Qualifier("queryDataSource")
    @ConfigurationProperties("datasource.query")
    public DataSource queryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("queryJdbcTemplate")
    JdbcTemplate queryJdbcTemplate(@Qualifier("queryDataSource") DataSource queryDataSource) {
        return new JdbcTemplate(queryDataSource);
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties queryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource eventuateDataSource() {
        return queryDataSourceProperties().initializeDataSourceBuilder().build();
    }

}