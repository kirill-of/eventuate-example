package pro.ofitserov.event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "pro.ofitserov.order.OrderAggregate")
public interface OrderEvent extends Event {
}
