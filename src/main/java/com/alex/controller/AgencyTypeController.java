package com.alex.controller;

import com.alex.DTO.AgencyTypeDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.AgencyType;
import com.alex.service.AgencyTypeService;
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
@RequestMapping(path = "/agency_type")
public class AgencyTypeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AgencyTypeController.class);

    @Autowired
    private AgencyTypeService agencyTypeService;

    @PostMapping
    public ResponseEntity<AgencyTypeDTO> createAgencyType(@Valid @RequestBody final AgencyType agencyType) {
        LOGGER.info("Added new AgencyType");
        return new ResponseEntity<AgencyTypeDTO>(new AgencyTypeDTO(agencyTypeService.addAgencyType(agencyType)),
                HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AgencyTypeDTO> updateAgencyType(
            @PathVariable("id") final int id,
            @Valid @RequestBody final AgencyType agencyType) {

        if (agencyTypeService.getAgencyTypeById(id) == null) {
            LOGGER.error("Can't put(updateAgencyType) an AgencyType with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateAgencyType) an AgencyType with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated AgencyType with id: " + id);
        agencyType.setId(id);
        return new ResponseEntity<AgencyTypeDTO>(new AgencyTypeDTO(agencyTypeService.updateAgencyType(agencyType)),
                HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AgencyTypeDTO>> getAllAgencyTypes() {
        LOGGER.info("Gave away all AgencyTypes");
        List<AgencyType> agencyTypes = agencyTypeService.getAgencyType();
        List<AgencyTypeDTO> agencyTypesDTO = new ArrayList<>();
        for (AgencyType agencyType:agencyTypes) {
            agencyTypesDTO.add(new AgencyTypeDTO(agencyType));
        }
        return new ResponseEntity<List<AgencyTypeDTO>>(agencyTypesDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AgencyTypeDTO> getAgencyType(@PathVariable(name = "id") final Integer id) {
        if (agencyTypeService.getAgencyTypeById(id) == null) {
            LOGGER.error("Can't get(getAgencyType) an AgencyType with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getParcel) an Parcel with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an AgencyType with id: " + id);
        return new ResponseEntity<AgencyTypeDTO>(new AgencyTypeDTO(agencyTypeService.getAgencyTypeById(id)),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AgencyType> deleteAgencyTypeById(@PathVariable("id") final Integer id) {
        if (agencyTypeService.getAgencyTypeById(id) == null) {
            LOGGER.error("Can't delete(deleteAgencyTypeById) an AgencyType with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteAgencyTypeById) an AgencyType with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted AgencyType with id: " + id);
        agencyTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

