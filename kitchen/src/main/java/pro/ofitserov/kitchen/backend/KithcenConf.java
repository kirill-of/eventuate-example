package pro.ofitserov.kitchen.backend;

import io.eventuate.jdbckafka.TramJdbcKafkaConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pro.ofitserov.kitchen.tram.MessageService;
import pro.ofitserov.kitchen.tram.TransactionKitchenConsumer;

@Configuration
@EnableAutoConfiguration
@Import({TramJdbcKafkaConfiguration.class})
public class KithcenConf {
    @Bean
    public TransactionKitchenConsumer myConsumer() {
        return new TransactionKitchenConsumer();
    }

    @Bean
    public MessageService messageService(TransactionKitchenConsumer consumer,
                                         io.eventuate.tram.messaging.consumer.MessageConsumer messageConsumer) {
        return new MessageService(consumer, messageConsumer);
    }
}