package com.alex.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event",schema = "event_agency")
public class Event extends GeneralModel{
    private Integer id;
    private String name;
    private String eventDuration;
    private String dateOfEvent;
    private EventAddress eventAddress;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "event_duration")
    public String getEventDuration() {
        return eventDuration;
    }

    @Basic
    @Column(name = "date_of_the_event")
    public String getDateOfEvent() {
        return dateOfEvent;
    }

    @OneToOne
    @JoinColumn(name = "event_address_id", referencedColumnName = "id", nullable = false)
    public EventAddress getEventAddress() {
        return eventAddress;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventDuration(String eventDuration) {
        this.eventDuration = eventDuration;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public void setEventAddress(EventAddress eventAddress) {
        this.eventAddress = eventAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id) && name.equals(event.name) && eventDuration.equals(event.eventDuration)
                && dateOfEvent.equals(event.dateOfEvent) && eventAddress.equals(event.eventAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, eventDuration, dateOfEvent, eventAddress);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventDuration='" + eventDuration + '\'' +
                ", dateOfEvent='" + dateOfEvent + '\'' +
                ", eventAddress=" + eventAddress +
                '}';
    }
}
