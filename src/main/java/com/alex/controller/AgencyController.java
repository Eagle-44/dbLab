package com.alex.controller;

import com.alex.DTO.AgencyDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.Agency;
import com.alex.service.AgencyService;
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
@RequestMapping(path = "/agency")
public class AgencyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AgencyController.class);

    @Autowired
    private AgencyService agencyService;

    @PostMapping
    public ResponseEntity<AgencyDTO> createAgency(@Valid @RequestBody final Agency agency) {
        agencyService.addAgency(agency);
        LOGGER.info("Added new agency");
        return new ResponseEntity<AgencyDTO>(new AgencyDTO(agency), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AgencyDTO> updateAgency(@PathVariable("id") final int id,
                                                  @Valid @RequestBody final Agency agency) {

        if (agencyService.getAgencyById(id) == null) {
            LOGGER.error("Can't put(updateAgency) an client with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateClient) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated client with id: " + id);
        agency.setId(id);
        agencyService.updateAgency(agency);
        return new ResponseEntity<AgencyDTO>(new AgencyDTO(agency), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AgencyDTO>> getAllAgencies() {
        LOGGER.info("Gave away all Agency");
        List<Agency> agencies = agencyService.getAgency();
        List<AgencyDTO> agenciesDTO = new ArrayList<>();
        for (Agency agency:agencies) {
            AgencyDTO agencyDTO = new AgencyDTO(agency);
            agenciesDTO.add(agencyDTO);
        }
        return new ResponseEntity<List<AgencyDTO>>(agenciesDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AgencyDTO> getAgency(@PathVariable(name = "id")final Integer id){
        if (agencyService.getAgencyById(id) == null) {
            LOGGER.error("Can't get(getAgency) an agency with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getAgency) an agency with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an agency with id: " + id);
        Agency agency = agencyService.getAgencyById(id);
        return new ResponseEntity<AgencyDTO>(new AgencyDTO(agency), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Agency> deleteAgencyById(@PathVariable("id") final Integer id) {
        if (agencyService.getAgencyById(id) == null) {
            LOGGER.error("Can't delete(deleteAgencyById) an agency with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteAgencyById) an agency with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted agency with id: " + id);
        agencyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
