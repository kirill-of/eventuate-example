package pro.ofitserov.order;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pro.ofitserov.order.backend.OrderBackendConf;

@SpringBootApplication
@Configuration
@Import({OrderBackendConf.class, EventuateDriverConfiguration.class})
@EnableAutoConfiguration
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}