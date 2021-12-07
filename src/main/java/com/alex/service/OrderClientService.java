package com.alex.service;


import com.alex.models.OrderClient;
import com.alex.repository.OrderClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import java.util.List;

@Service
@ApplicationScope
public class OrderClientService {

    @Autowired
    OrderClientRepository orderClientRepository;

    public OrderClient addOrderClient(final OrderClient eventAddress){
        return orderClientRepository.save(eventAddress);
    }

    public OrderClient updateOrderClient(final OrderClient eventAddress){
        return orderClientRepository.save(eventAddress);
    }

    public List<OrderClient> getOrderClient() {
        return orderClientRepository.findAll();
    }

    public OrderClient getOrderClientById(final Integer id){
        return orderClientRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        orderClientRepository.deleteById(id);
    }
}
