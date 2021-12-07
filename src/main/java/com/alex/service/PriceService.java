package com.alex.service;


import com.alex.models.Price;
import com.alex.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import java.util.List;

@Service
@ApplicationScope
public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public Price addPrice(final Price price){
        return priceRepository.save(price);
    }

    public Price updatePrice(final Price price){
        return priceRepository.save(price);
    }

    public List<Price> getPrice() {
        return priceRepository.findAll();
    }

    public Price getPriceById(final Integer id){
        return priceRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        priceRepository.deleteById(id);
    }
}
