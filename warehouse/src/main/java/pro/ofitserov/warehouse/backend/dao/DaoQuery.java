package pro.ofitserov.warehouse.backend.dao;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pro.ofitserov.model.OrderEntity;

import javax.sql.DataSource;

@Repository
public class DaoQuery {

    private static final Logger logger = LoggerFactory.getLogger(DaoQuery.class);
    @Autowired
    @Qualifier("queryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("queryDataSource")
    DataSource dataSource;

    public OrderEntity findStatusByAggregateId(String aggregateId) {
        String sql = "SELECT * FROM order_table WHERE aggregateId =(?)";
        RowMapper<OrderEntity> rowMapper = new BeanPropertyRowMapper<OrderEntity>(OrderEntity.class);
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, aggregateId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void changeStatus(String aggregateId, String status) {
        jdbcTemplate.update("UPDATE order_table set status = ?  WHERE aggregateId=?", status, aggregateId);
    }
}
