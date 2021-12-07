package com.alex.DTO;

import com.alex.models.Event;
import com.alex.models.EventAddress;

public class EventDTO {
    private Event event;

    public EventDTO(Event event){
        this.event = event;
    }

    public Integer getId() {
        return event.getId();
    }

    public String getName() {
        return event.getName();
    }

    public String getEventDuration() {
        return event.getEventDuration();
    }

    public EventAddress getEventAddress() {
        return event.getEventAddress();
    }

    public String getDateOfEvent() {
        return event.getDateOfEvent();
    }
}
