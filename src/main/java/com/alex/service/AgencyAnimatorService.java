package com.alex.service;

import com.alex.models.AgencyAnimator;
import com.alex.repository.AgencyAnimatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyAnimatorService {

    @Autowired
    AgencyAnimatorRepository agencyAnimatorRepository;
    public AgencyAnimator addAgencyAnimator(final AgencyAnimator agencyAnimator){
        return agencyAnimatorRepository.save(agencyAnimator);
    }

    public AgencyAnimator updateAgencyAnimator(final AgencyAnimator agencyAnimator){
        return agencyAnimatorRepository.save(agencyAnimator);
    }

    public List<AgencyAnimator> getAgencyAnimator() {
        return agencyAnimatorRepository.findAll();
    }

    public AgencyAnimator getAgencyAnimatorById(final Integer id){
        return agencyAnimatorRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        agencyAnimatorRepository.deleteById(id);
    }
}
