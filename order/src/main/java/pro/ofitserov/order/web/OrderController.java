package pro.ofitserov.order.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.ofitserov.order.backend.model.CreateOrderEntity;
import pro.ofitserov.order.backend.service.OrderService;

import java.util.concurrent.ExecutionException;

@Api(value = "order-service", description = "Order service")
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create")
    @ApiOperation(value = "Create order")
    public ResponseEntity createOrder(@RequestBody CreateOrderEntity body) throws ExecutionException, InterruptedException {
        return orderService.create(body);
    }

    @GetMapping(value = "/info")
    @ApiOperation(value = "Test info")
    public ResponseEntity getInfo() {
        return new ResponseEntity("sdfsdf", HttpStatus.OK);
    }

    @PutMapping(value = "/changeStatus")
    @ApiOperation(value = "Change status")
    public ResponseEntity changePhone(@RequestHeader String status, @RequestHeader String aggregateId) {
        orderService.changeStatus(status, aggregateId);
        return new ResponseEntity("new status = " + status, HttpStatus.OK);
    }
}