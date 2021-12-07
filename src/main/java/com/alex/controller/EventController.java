package com.alex.controller;

import com.alex.DTO.EventDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.Event;
import com.alex.service.EventService;
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
@RequestMapping(path = "/event")
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody final Event event) {
        eventService.addEvent(event);
        LOGGER.info("Added new Event");
        return new ResponseEntity<EventDTO>(new EventDTO(event), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EventDTO> updateClient(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Event event) {

        if (eventService.getEventById(id) == null) {
            LOGGER.error("Can't put(updateEvent) an Event with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateEvent) an Event with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Event with id: " + id);
        event.setId(id);
        eventService.updateEvent(event);
        return new ResponseEntity<EventDTO>(new EventDTO(event), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        LOGGER.info("Gave away all Events");
        List<Event> events = eventService.getEvent();
        List<EventDTO> eventsDTO = new ArrayList<>();
        for (Event event:events) {
            EventDTO eventDTO = new EventDTO(event);
            eventsDTO.add(eventDTO);
        }
        return new ResponseEntity<List<EventDTO>>(eventsDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable(name = "id") final Integer id) {
        if (eventService.getEventById(id) == null) {
            LOGGER.error("Can't get(getEvent) an Event with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getEvent) an Event with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Event with id: " + id);
        Event event = eventService.getEventById(id);
        return new ResponseEntity<EventDTO>(new EventDTO(event), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Event> deleteEventById(@PathVariable("id") final Integer id) {
        if (eventService.getEventById(id) == null) {
            LOGGER.error("Can't delete(deleteEventById) an Event with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteEventById) an Event with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted Event with id: " + id);
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
