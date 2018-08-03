package pro.ofitserov.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private String orderId;
    private String nameClient;
    String dish;
    String status;
}
