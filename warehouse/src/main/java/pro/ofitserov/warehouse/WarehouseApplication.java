package pro.ofitserov.warehouse;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pro.ofitserov.warehouse.backend.WarehouseConf;

@SpringBootApplication
@Import({WarehouseConf.class, EventuateDriverConfiguration.class})
public class WarehouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class, args);
    }
}