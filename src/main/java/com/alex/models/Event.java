package com.alex.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "event",schema = "event_agency")
public class Event extends GeneralModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name")
    @NotNull(message = "Miss name")
    private String name;

    @Basic
    @Column(name = "event_duration")
    @NotNull(message = "Miss eventDuration")
    private String eventDuration;

    @Basic
    @Column(name = "date_of_the_event")
    @NotNull(message = "Miss dateOfTheEvent")
    private String dateOfEvent;

    @OneToOne
    @JoinColumn(name = "event_address_id", referencedColumnName = "id", nullable = false)
    private EventAddress eventAddress;

    public Event (final String name, final String eventDuration, final String dateOfEvent,
                  final EventAddress eventAddress) {
        this.name = name;
        this.eventDuration = eventDuration;
        this.dateOfEvent = dateOfEvent;
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
