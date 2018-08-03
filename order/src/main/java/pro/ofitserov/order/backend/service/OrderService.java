package pro.ofitserov.order.backend.service;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.ofitserov.order.OrderAggregate;
import pro.ofitserov.order.backend.model.CreateOrderEntity;
import pro.ofitserov.order.command.CreateOrderCommand;
import pro.ofitserov.order.command.OrderCommand;
import pro.ofitserov.order.command.UpdateStatusOrderCommand;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final AggregateRepository<OrderAggregate, OrderCommand> aggregateRepository;

    public OrderService(AggregateRepository<OrderAggregate, OrderCommand> aggregateRepository) {
        this.aggregateRepository = aggregateRepository;
    }

    public ResponseEntity create(CreateOrderEntity entity) throws ExecutionException, InterruptedException {
        logger.info("Order data {}", entity);
        CompletableFuture<EntityWithIdAndVersion<OrderAggregate>> aggregate = aggregateRepository.save(new CreateOrderCommand(entity));

        logger.info("aggregate {}", aggregate.get().getAggregate().getOrder());
        return new ResponseEntity(aggregate.get().getAggregate().getOrder(), HttpStatus.OK);
    }

    public CompletableFuture<EntityWithIdAndVersion<OrderAggregate>> changeStatus(String aggregateId, String status) {
        logger.info("changeStatus aggregateId = {}, status = {}", aggregateId, status);
        return aggregateRepository.update(aggregateId, new UpdateStatusOrderCommand(status));
    }
}
