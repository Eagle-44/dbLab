package com.alex.controller;


import com.alex.DTO.OrderClientDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.OrderClient;
import com.alex.service.OrderClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/order_client")
public class OrderClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderClientController.class);

    @Autowired
    private OrderClientService orderClientService;

    @PostMapping
    public ResponseEntity<OrderClientDTO> createOrderClient(@Valid @RequestBody final OrderClient orderClient) {
        LOGGER.info("Added new OrderClient");
        return new ResponseEntity<OrderClientDTO>(new OrderClientDTO(orderClientService.addOrderClient(orderClient)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<OrderClientDTO> updateOrderClient(
            @PathVariable("id") final int id,
            @Valid @RequestBody final OrderClient orderClient) {

        if (orderClientService.getOrderClientById(id) == null) {
            LOGGER.error("Can't put(updateOrderClient) an OrderClient with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateOrderClient) an OrderClient with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated OrderClient with id: " + id);
        orderClient.setId(id);
        return new ResponseEntity<OrderClientDTO>(new OrderClientDTO(orderClientService.updateOrderClient(orderClient)),
                HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<OrderClientDTO>> getAllOrderClients() {
        LOGGER.info("Gave away all Indents");
        List<OrderClient> orderClients = orderClientService.getOrderClient();
        List<OrderClientDTO> orderClientsDTO = new ArrayList<>();
        for (OrderClient orderClient:orderClients) {
            orderClientsDTO.add(new OrderClientDTO(orderClient));
        }
        return new ResponseEntity<List<OrderClientDTO>>(orderClientsDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderClientDTO> getOrderClient(@PathVariable(name = "id") final Integer id) {
        if (orderClientService.getOrderClientById(id) == null) {
            LOGGER.error("Can't get(getOrderClient) an OrderClient with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getOrderClient) an OrderClient with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an OrderClient with id: " + id);
        return new ResponseEntity<OrderClientDTO>(new OrderClientDTO(orderClientService.getOrderClientById(id)),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<OrderClient> deleteOrderClientById(@PathVariable("id") final Integer id) {
        if (orderClientService.getOrderClientById(id) == null) {
            LOGGER.error("Can't delete(deleteOrderClientById) an OrderClient with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteOrderClientById) an OrderClient with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted OrderClient with id: " + id);
        orderClientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
