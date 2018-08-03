package pro.ofitserov.warehouse.backend;

import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import pro.ofitserov.warehouse.backend.dao.DaoConfig;
import pro.ofitserov.warehouse.eventHandler.EventHandlerWarehouse;

import javax.sql.DataSource;

@EnableEventHandlers
@Import({DaoConfig.class, TramJdbcKafkaConfiguration.class})
public class WarehouseConf {

    @Bean
    public EventHandlerWarehouse eventHandler() {
        return new EventHandlerWarehouse();
    }

    @Primary
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /*@Bean(name = "kitchen")
    public WebClient transaction(@Value("${kitchen}") String baseUrl) {
        return WebClient.builder().baseUrl(baseUrl).build();
    }*/
}
