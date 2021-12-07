package com.alex.controller;

import com.alex.DTO.EventAddressDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.EventAddress;
import com.alex.service.EventAddressService;
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
@RequestMapping(path = "/event_address")
public class EventAddressController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventAddressController.class);

    @Autowired
    private EventAddressService eventAddressService;

    @PostMapping
    public ResponseEntity<EventAddressDTO> createClient(@Valid @RequestBody final EventAddress eventAddress) {
        eventAddressService.addEventAddress(eventAddress);
        LOGGER.info("Added new EventAddress");
        return new ResponseEntity<EventAddressDTO>(new EventAddressDTO(eventAddress), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EventAddressDTO> updateEventAddress(
            @PathVariable("id") final int id,
            @Valid @RequestBody final EventAddress eventAddress) {

        if (eventAddressService.getEventAddressById(id) == null) {
            LOGGER.error("Can't put(updateEventAddress) an EventAddress with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateEventAddress) an EventAddress with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated EventAddress with id: " + id);
        eventAddress.setId(id);
        eventAddressService.updateEventAddress(eventAddress);
        return new ResponseEntity<EventAddressDTO>(new EventAddressDTO(eventAddress), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<EventAddressDTO>> getAllEventAddresses() {
        LOGGER.info("Gave away all EventAddresses");
        List<EventAddress> eventAddresses= eventAddressService.getEventAddress();
        List<EventAddressDTO> eventAddressesDTO = new ArrayList<>();
        for (EventAddress eventAddress:eventAddresses) {
            EventAddressDTO eventAddressDTO = new EventAddressDTO(eventAddress);
            eventAddressesDTO.add(eventAddressDTO);
        }
        return new ResponseEntity<List<EventAddressDTO>>(eventAddressesDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EventAddressDTO> getEventAddress(@PathVariable(name = "id") final Integer id) {
        if (eventAddressService.getEventAddressById(id) == null) {
            LOGGER.error("Can't get(getEventAddress) an EventAddress with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getEventAddress) an EventAddress with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an EventAddress with id: " + id);
        EventAddress eventAddress = eventAddressService.getEventAddressById(id);
        return new ResponseEntity<EventAddressDTO>(new EventAddressDTO(eventAddress), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<EventAddress> deleteEventAddressById(@PathVariable("id") final Integer id) {
        if (eventAddressService.getEventAddressById(id) == null) {
            LOGGER.error("Can't delete(deleteEventAddressById) an EventAddress with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteEventAddressById) an EventAddress with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted EventAddress with id: " + id);
        eventAddressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
