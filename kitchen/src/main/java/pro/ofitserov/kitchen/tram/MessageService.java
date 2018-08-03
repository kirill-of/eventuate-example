package pro.ofitserov.kitchen.tram;

import lombok.Getter;

import java.util.Collections;

@Getter
public class MessageService {

    public MessageService(TransactionKitchenConsumer myConsumer,
                          io.eventuate.tram.messaging.consumer.MessageConsumer messageConsumer) {
        messageConsumer.subscribe("kitchenSubscriber",
                Collections.singleton("KitchenDestination"),
                myConsumer::handler);
    }
}
