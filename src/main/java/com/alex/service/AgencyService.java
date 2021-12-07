package com.alex.service;

import com.alex.models.Agency;
import com.alex.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AgencyService {

    @Autowired
    AgencyRepository agencyRepository;

    public Agency addAgency(final Agency agency){
        return agencyRepository.save(agency);
    }

    public Agency updateAgency(final Agency agency){
        return agencyRepository.save(agency);
    }

    public List<Agency> getAgency() {
        return agencyRepository.findAll();
    }

    public Agency getAgencyById(final Integer id){
        return agencyRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        agencyRepository.deleteById(id);
    }
}


