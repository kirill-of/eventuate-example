package pro.ofitserov.waiter.eventHandler;

import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.ofitserov.event.UpdateStatusOrderEvent;

public class EventHandlerWaiter {
    private static final Logger logger = LoggerFactory.getLogger(EventHandlerWaiter.class);

    @EventHandlerMethod
    public void checkStatus(DispatchedEvent<UpdateStatusOrderEvent> event) {
        logger.info("UpdateStatusOrderEvent received: {}", event);
        logger.info("Get UpdateStatusOrderEvent: [{}]. offset:[{}], swimlane:[{}]", event.getEvent(), event.getOffset(), event.getSwimlane());

        logger.info("Waiter check status ....");

        logger.info("New status = ", event.getEvent().getStatus());


    }
}
