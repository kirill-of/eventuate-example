package pro.ofitserov.order.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pro.ofitserov.order.backend.model.CreateOrderEntity;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderCommand implements OrderCommand {
    private String orderId;
    private String nameClient;
    String dish;
    String status;

    public CreateOrderCommand(CreateOrderEntity orderEntity) {
        this.orderId = orderEntity.getNameClient() + orderEntity.getDish();
        this.nameClient = orderEntity.getNameClient();
        this.dish = orderEntity.getDish();
        this.status = "created";
    }
}
