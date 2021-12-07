package com.alex.service;


import com.alex.models.EventAddress;
import com.alex.repository.EventAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import java.util.List;

@Service
@ApplicationScope
public class EventAddressService {

    @Autowired
    EventAddressRepository eventAddressRepository;

    public EventAddress addEventAddress(final EventAddress eventAddress){
        return eventAddressRepository.save(eventAddress);
    }

    public EventAddress updateEventAddress(final EventAddress eventAddress){
        return eventAddressRepository.save(eventAddress);
    }

    public List<EventAddress> getEventAddress() {
        return eventAddressRepository.findAll();
    }

    public EventAddress getEventAddressById(final Integer id){
        return eventAddressRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        eventAddressRepository.deleteById(id);
    }
}
