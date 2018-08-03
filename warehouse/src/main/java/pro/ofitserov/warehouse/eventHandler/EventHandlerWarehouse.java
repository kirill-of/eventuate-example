package pro.ofitserov.warehouse.eventHandler;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import io.eventuate.tram.messaging.producer.MessageBuilder;
import io.eventuate.tram.messaging.producer.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pro.ofitserov.event.CreateEvent;
import pro.ofitserov.tramMessage.ManageMessage;
import pro.ofitserov.warehouse.backend.dao.DaoQuery;

@EventSubscriber
public class EventHandlerWarehouse {
    private static final Logger logger = LoggerFactory.getLogger(EventHandlerWarehouse.class);


    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private DaoQuery service;

    @EventHandlerMethod
    public void checkWarehouse(DispatchedEvent<CreateEvent> event) {
        logger.info("CreateOrderEvent received: {}", event);
        logger.info("Get CreateOrderEvent: [{}]. offset:[{}], swimlane:[{}]", event.getEvent(), event.getOffset(), event.getSwimlane());

        //search for ingredients for
        logger.info("checking new order... search for ingredients for " + event.getEvent().getDish());

        messageProducer.send("KitchenDestination",
                MessageBuilder.
                        withPayload(new ManageMessage().toString()).
                        withHeader("aggregateId", event.getEntityId()).
                        withHeader("status", event.getEvent().getStatus()).
                        build());
        logger.info("after send message");

       /* if (event.getEvent().getDish().length() < 4) {
            logger.info("Order is accepted");
            service.changeStatus(event.getEntityId(), "accepted");
        } else {
            logger.info("Order cancelled");
            service.changeStatus(event.getEntityId(), "cancelled");
        }*/
    }

    /*@EventHandlerMethod
    public void updateStatus(DispatchedEvent<UpdateStatusOrderEvent> event) {
        logger.info("UpdateStatusOrderEvent received: {}", event);
        logger.info("Get UpdateStatusOrderEvent: [{}]. offset:[{}], swimlane:[{}]",
                event.getEvent(), event.getOffset(), event.getSwimlane());

        //service.changeStatus(event.getEvent().getStatus(), event.getEntityId());
    }*/
}
