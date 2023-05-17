package com.example.serviceImplementation;

import com.example.model.ClientModel;
import com.example.repository.ClientRepository;
import com.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImplementation implements ClientService {
    @Autowired
    ClientRepository repo;
    @Override
    public ClientModel saveClient(ClientModel client) {
        return repo.save(client);
    }

    @Override
    public List<ClientModel> listClients() {
        return repo.findAll();
    }

    @Override
    public ClientModel findClientById(ClientModel client) {
        return repo.findById(client.getId()).orElse(null);
    }

    @Override
    public ClientModel updateClient(ClientModel client) {
        ClientModel savedClient = repo.findById(client.getId()).orElse(null);
        if (savedClient!=null){
            savedClient.setFirstname(client.getFirstname());
            savedClient.setLastname(client.getLastname());
            savedClient.setAddress(client.getAddress());
            savedClient.setId_no(client.getId_no());
            savedClient.setOutDate(client.getOutDate());
            savedClient.setEntranceDate(client.getEntranceDate());
            savedClient.setRoom_no(client.getRoom_no());
            savedClient.setPaid_money(client.getPaid_money());
            savedClient.setPhone(client.getPhone());

            return repo.save(savedClient);
        }
        return repo.save(client);
    }

    @Override
    public void deleteClient(ClientModel client) {
        ClientModel savedClient = repo.findById(client.getId()).orElse(null);
        if (savedClient!=null){
            repo.delete(savedClient);
        }
    }
}
