package pro.ofitserov.order.backend.dao;

import org.springframework.jdbc.core.RowMapper;
import pro.ofitserov.model.OrderEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<OrderEntity> {
    @Override
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderEntity entity = new OrderEntity();

        entity.setAggregateId(rs.getString("aggregateId"));
        entity.setStatus(rs.getString("status"));
        return entity;
    }
}
