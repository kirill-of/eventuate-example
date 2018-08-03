package pro.ofitserov.kitchen.tram;

import io.eventuate.EventHandlerMethod;
import io.eventuate.tram.messaging.common.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionKitchenConsumer {

    private static final Logger logger = LoggerFactory.getLogger(TransactionKitchenConsumer.class);

    @EventHandlerMethod
    public void handler(Message message) {
        logger.info("message received: {}", message.getHeaders());
        logger.info("Cooking....");
        //query.newTransaction(aggregateId, operation, amount);
    }
}
