package pro.ofitserov.warehouse.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "warehouse")
public class WarehouseController {

    @GetMapping
    @RequestMapping(value = "/info/")
    public ResponseEntity getInfo() {
        return new ResponseEntity("info...", HttpStatus.OK);
    }
}
