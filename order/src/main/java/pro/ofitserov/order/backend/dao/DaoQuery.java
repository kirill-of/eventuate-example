package pro.ofitserov.order.backend.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

    public void insertEvent(String aggregateId, String status) {
        try {
            jdbcTemplate.update(
                    "INSERT INTO order_table(aggregateId, status) VALUES (?,?)",
                    aggregateId, status);
            logger.info("Insert new Order");
        } catch (RuntimeException e) {
            logger.info(e.getMessage());

        }
    }
}
