package com.alex.service;


import com.alex.models.Client;
import com.alex.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import java.util.List;

@Service
@ApplicationScope
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client addClient(final Client client){
        return clientRepository.save(client);
    }

    public Client updateClient(final Client client){
        return clientRepository.save(client);
    }

    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(final Integer id){
        return clientRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        clientRepository.deleteById(id);
    }
}
