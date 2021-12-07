package com.alex.controller;

import com.alex.DTO.ClientDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.Client;
import com.alex.service.ClientService;
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
@RequestMapping(path = "/client")
public class ClientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody final Client client) {
        clientService.addClient(client);
        LOGGER.info("Added new Client");
        return new ResponseEntity<ClientDTO>(new ClientDTO(client), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientDTO> updateClient(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Client client) {

        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't put(updateClient) an client with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateClient) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated client with id: " + id);
        client.setId(id);
        clientService.updateClient(client);
        return new ResponseEntity<ClientDTO>(new ClientDTO(client), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        LOGGER.info("Gave away all Clients");
        List<Client> clients = clientService.getClient();
        List<ClientDTO> clientsDTO = new ArrayList<>();
        for (Client client:clients) {
            ClientDTO clientDTO = new ClientDTO(client);
            clientsDTO.add(clientDTO);
        }
        return new ResponseEntity<List<ClientDTO>>(clientsDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable(name = "id") final Integer id) {
        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't get(getClient) an client with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getClient) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an client with id: " + id);
        Client client = clientService.getClientById(id);
        return new ResponseEntity<ClientDTO>(new ClientDTO(client), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Client> deleteClientById(@PathVariable("id") final Integer id) {
        if (clientService.getClientById(id) == null) {
            LOGGER.error("Can't delete(deleteClientById) an client with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteClientById) an client with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted client with id: " + id);
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
