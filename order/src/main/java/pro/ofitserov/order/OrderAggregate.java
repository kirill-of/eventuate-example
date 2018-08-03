package pro.ofitserov.order;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import lombok.Getter;
import pro.ofitserov.event.CreateEvent;
import pro.ofitserov.model.Order;
import pro.ofitserov.order.command.CreateOrderCommand;
import pro.ofitserov.order.command.OrderCommand;

import java.util.List;

public class OrderAggregate extends ReflectiveMutableCommandProcessingAggregate<OrderAggregate, OrderCommand> {

    @Getter
    private Order order = new Order();

    public List<Event> process(CreateOrderCommand cmd) {
        return EventUtil.events(new CreateEvent(
                cmd.getOrderId(),
                cmd.getNameClient(),
                cmd.getDish(),
                cmd.getStatus()));
    }

    public void apply(CreateEvent event) {
        this.order.setOrderId(event.getOrderId());
        this.order.setNameClient(event.getNameClient());
        this.order.setDish(event.getDish());
        this.order.setStatus(event.getStatus());
    }
}
