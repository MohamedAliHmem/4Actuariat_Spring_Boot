package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IClientService {
    Client addClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long idClient);

    Client findClientById(Long idClient);

    List<Client> findAllClients();
}
