package pro.ofitserov.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderEntity {
    private String aggregateId;
    private String status;
}