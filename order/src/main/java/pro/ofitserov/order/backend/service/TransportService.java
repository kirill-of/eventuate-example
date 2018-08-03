package pro.ofitserov.order.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

public class TransportService {
    private static final Logger logger = LoggerFactory.getLogger(TransportService.class);

    @Autowired
    @Qualifier("warehouse")
    private WebClient warehouse;


}
