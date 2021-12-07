package com.alex.controller;

import com.alex.DTO.AgencyAnimatorDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.AgencyAnimator;
import com.alex.service.AgencyAnimatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/agency_animator")
public class AgencyAnimatorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AgencyAnimatorController.class);

    @Autowired
    private AgencyAnimatorService agencyAnimatorService;

    @PostMapping
    public ResponseEntity<AgencyAnimatorDTO> createAgencyAnimator(
            @Valid @RequestBody final AgencyAnimator agencyAnimator) {
        LOGGER.info("Added new AgencyAnimator");
        return new ResponseEntity<AgencyAnimatorDTO>(new AgencyAnimatorDTO(
                agencyAnimatorService.addAgencyAnimator(agencyAnimator)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AgencyAnimatorDTO> updateAgencyAnimator(
            @PathVariable("id") final int id,
            @Valid @RequestBody final AgencyAnimator agencyAnimator) {

        if (agencyAnimatorService.getAgencyAnimatorById(id) == null) {
            LOGGER.error("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateAgencyAnimator) an AgencyAnimator with non-existing id: "
                    + id);
        }
        LOGGER.info("Successfully updated AgencyAnimator with id: " + id);
        agencyAnimator.setId(id);
        return new ResponseEntity<AgencyAnimatorDTO>(new AgencyAnimatorDTO(agencyAnimatorService.updateAgencyAnimator
                (agencyAnimator)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AgencyAnimatorDTO>> getAllAgencyAnimators() {
        LOGGER.info("Gave away all AgencyAnimators");
        List<AgencyAnimator> agencyAnimators = agencyAnimatorService.getAgencyAnimator();
        List<AgencyAnimatorDTO> agencyAnimatorsDTO = new ArrayList<>();
        for (AgencyAnimator agencyAnimator:agencyAnimators) {
            agencyAnimatorsDTO.add(new AgencyAnimatorDTO(agencyAnimator));
        }
        return new ResponseEntity<List<AgencyAnimatorDTO>>(agencyAnimatorsDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AgencyAnimatorDTO> getAgencyAnimator(@PathVariable(name = "id") final Integer id) {
        if (agencyAnimatorService.getAgencyAnimatorById(id) == null) {
            LOGGER.error("Can't get(getAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getAgencyAnimator) an AgencyAnimator with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an client with id: " + id);
        return new ResponseEntity<AgencyAnimatorDTO>(new AgencyAnimatorDTO(
                agencyAnimatorService.getAgencyAnimatorById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AgencyAnimator> deleteAgencyAnimatorById(@PathVariable("id") final Integer id) {
        if (agencyAnimatorService.getAgencyAnimatorById(id) == null) {
            LOGGER.error("Can't delete(deleteAgencyAnimatorById) an AgencyAnimator with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteAgencyAnimatorById) an AgencyAnimator with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted AgencyAnimator with id: " + id);
        agencyAnimatorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

