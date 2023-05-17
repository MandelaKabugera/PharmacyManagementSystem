package com.example.service;

import com.example.model.ClientModel;

import java.util.List;

public interface ClientService {
    ClientModel saveClient(ClientModel client);
    List<ClientModel> listClients();
    ClientModel findClientById(ClientModel client);
    ClientModel updateClient(ClientModel client);
    void deleteClient(ClientModel client);
}
