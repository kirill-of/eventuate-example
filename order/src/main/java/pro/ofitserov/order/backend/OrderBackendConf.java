package pro.ofitserov.order.backend;

import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import pro.ofitserov.order.OrderAggregate;
import pro.ofitserov.order.backend.dao.DaoConfig;
import pro.ofitserov.order.command.OrderCommand;
import pro.ofitserov.order.eventhandler.EventHandlerOrder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableEventHandlers
@EnableSwagger2
@Import({DaoConfig.class, TramJdbcKafkaConfiguration.class})
public class OrderBackendConf {


    @Bean
    public AggregateRepository<OrderAggregate, OrderCommand> aggregateRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(OrderAggregate.class, eventStore);
    }

    @Bean
    public EventHandlerOrder eventHandler() {
        return new EventHandlerOrder();
    }

    @Primary
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /*@Bean(name = "warehouse")
    public WebClient warehouse(@Value("${warehouse}") String baseUrl) {
        return WebClient.builder().baseUrl(baseUrl).build();
    }*/

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pro.ofitserov.order.web"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Order Microserivce",
                "Set of operations to work with order aggregate",
                null,
                null,
                null,
                null,
                null,
                Stream.of(new StringVendorExtension("Company", "Neoflex")).collect(Collectors.toList())
        );
    }
}
