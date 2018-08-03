package pro.ofitserov.order.backend.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateOrderEntity {
    private String nameClient;
    private String dish;
}
