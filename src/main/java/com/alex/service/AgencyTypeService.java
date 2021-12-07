package com.alex.service;

import com.alex.models.AgencyType;
import com.alex.repository.AgencyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgencyTypeService {

    @Autowired
    AgencyTypeRepository agencyTypeRepository;
    public AgencyType addAgencyType(final AgencyType agencyType){
        return agencyTypeRepository.save(agencyType);
    }

    public AgencyType updateAgencyType(final AgencyType agencyType){
        return agencyTypeRepository.save(agencyType);
    }

    public List<AgencyType> getAgencyType() {
        return agencyTypeRepository.findAll();
    }

    public AgencyType getAgencyTypeById(final Integer id){
        return agencyTypeRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        agencyTypeRepository.deleteById(id);
    }
}
