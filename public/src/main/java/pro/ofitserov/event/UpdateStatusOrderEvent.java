package pro.ofitserov.event;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateStatusOrderEvent implements OrderEvent {
    String status;
}

