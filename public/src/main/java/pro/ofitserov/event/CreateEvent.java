package pro.ofitserov.event;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateEvent implements OrderEvent {
    private String orderId;
    private String nameClient;
    String dish;
    String status;
}