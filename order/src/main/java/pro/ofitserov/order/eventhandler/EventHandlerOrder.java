package pro.ofitserov.order.eventhandler;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pro.ofitserov.event.CreateEvent;
import pro.ofitserov.order.backend.dao.DaoQuery;

@EventSubscriber
public class EventHandlerOrder {
    private static final Logger logger = LoggerFactory.getLogger(EventHandlerOrder.class);

    @Autowired
    private DaoQuery query;

    @EventHandlerMethod
    public void registerStatus(DispatchedEvent<CreateEvent> event) {
        logger.info("CreateOrderEvent received: {}", event);
        logger.info("Get CreateOrderEvent: [{}]. offset:[{}], swimlane:[{}]",
                event.getEvent(), event.getOffset(), event.getSwimlane());

        query.insertEvent(event.getEntityId(), event.getEvent().getStatus());
        logger.info("Save in DB");
    }
}
