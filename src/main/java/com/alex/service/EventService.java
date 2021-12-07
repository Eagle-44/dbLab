package com.alex.service;


import com.alex.models.Event;
import com.alex.models.EventAddress;
import com.alex.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public Event addEvent(final Event event){
        return eventRepository.save(event);
    }

    public Event updateEvent(final Event event){
        return eventRepository.save(event);
    }

    public List<Event> getEvent() {
        return eventRepository.findAll();
    }

    public Event getEventById(final Integer id){
        return eventRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        eventRepository.deleteById(id);
    }
}
