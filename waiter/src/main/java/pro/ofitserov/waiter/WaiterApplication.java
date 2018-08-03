package pro.ofitserov.waiter;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pro.ofitserov.waiter.backend.WaiterConf;

@SpringBootApplication
@Import({WaiterConf.class, EventuateDriverConfiguration.class})

public class WaiterApplication {
    public static void main(String[] args) {
        SpringApplication.run(WaiterApplication.class, args);
    }
}
