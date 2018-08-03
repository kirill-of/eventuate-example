package pro.ofitserov.warehouse.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.ofitserov.model.OrderEntity;
import pro.ofitserov.warehouse.backend.dao.DaoQuery;
import pro.ofitserov.warehouse.backend.exception.NotFound;

@Service
public class WarehouseService {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseService.class);
    @Autowired
    private DaoQuery query;

    public ResponseEntity newStatus(String aggregateId, String newStatus) {
        OrderEntity entity = query.findStatusByAggregateId(aggregateId);
        logger.info("updateEntity {}", entity);
        if (entity == null) {
            throw new NotFound("Not found");
        }

        query.changeStatus(newStatus, aggregateId);
        OrderEntity updateEntity = query.findStatusByAggregateId(aggregateId);
        logger.info("updateEntity {}", updateEntity);
        return new ResponseEntity(updateEntity, HttpStatus.OK);
    }
}
