package com.alex.controller;

import com.alex.DTO.PriceDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.Price;
import com.alex.service.PriceService;
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
@RequestMapping(path = "/price")
public class PriceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceService priceService;

    @PostMapping
    public ResponseEntity<PriceDTO> createPrice(@Valid @RequestBody final Price price) {
        LOGGER.info("Added new technique");
        return new ResponseEntity<PriceDTO>(new PriceDTO(priceService.addPrice(price)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PriceDTO> updatePrice(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Price price) {

        if (priceService.getPriceById(id) == null) {
            LOGGER.error("Can't put(updatePrice) an Price with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updatePrice) an Price with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Price with id: " + id);
        price.setId(id);
        return new ResponseEntity<PriceDTO>(new PriceDTO(priceService.updatePrice(price)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<PriceDTO>> getAllPrices() {
        LOGGER.info("Gave away all Prices");
        List<Price> prices = priceService.getPrice();
        List<PriceDTO> pricesDTO = new ArrayList<>();
        for (Price price:prices) {
            pricesDTO.add(new PriceDTO(price));
        }
        return new ResponseEntity<List<PriceDTO>>(pricesDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PriceDTO> getPrice(@PathVariable(name = "id") final Integer id) {
        if (priceService.getPriceById(id) == null) {
            LOGGER.error("Can't get(getPrice) an Price with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getPrice) an Price with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an client with id: " + id);
        return new ResponseEntity<PriceDTO>(new PriceDTO(priceService.getPriceById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Price> deletePriceById(@PathVariable("id") final Integer id) {
        if (priceService.getPriceById(id) == null) {
            LOGGER.error("Can't delete(deletePriceById) an Price with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deletePriceById) an Price with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted Price with id: " + id);
        priceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
