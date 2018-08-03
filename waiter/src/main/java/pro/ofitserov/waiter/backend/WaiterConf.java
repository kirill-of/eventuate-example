package pro.ofitserov.waiter.backend;

import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import pro.ofitserov.waiter.backend.dao.DaoConfig;
import pro.ofitserov.waiter.eventHandler.EventHandlerWaiter;

import javax.sql.DataSource;

@EnableEventHandlers
@Import({DaoConfig.class, TramJdbcKafkaConfiguration.class})
public class WaiterConf {

    @Bean
    public EventHandlerWaiter eventHandler() {
        return new EventHandlerWaiter();
    }

    @Primary
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}