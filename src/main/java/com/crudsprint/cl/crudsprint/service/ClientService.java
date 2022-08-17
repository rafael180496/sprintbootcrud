package com.crudsprint.cl.crudsprint.service;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crudsprint.cl.crudsprint.entity.Client;
import com.crudsprint.cl.crudsprint.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    @PostConstruct
    public void init() {
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client insertClient(Client client) {
        return clientRepository.save(client);
    }
    public Client find(String rut) {
        List<Client> result =  clientRepository.findByRut(rut);
        if(result.isEmpty()){
            return null;
        }
        return result.get(0);
    }
}