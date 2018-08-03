package pro.ofitserov.kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pro.ofitserov.kitchen.backend.KithcenConf;

@SpringBootApplication
@EnableAutoConfiguration
@Import({KithcenConf.class})
public class KitchenApplication {
    public static void main(String[] args) {
        SpringApplication.run(KitchenApplication.class, args);
    }
}


