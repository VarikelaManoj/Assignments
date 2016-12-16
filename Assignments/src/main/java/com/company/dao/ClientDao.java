package com.company.dao;

import java.util.List;

import com.company.model.Client;

public interface ClientDao {
void addClient(Client client);
List<Client> viewClients();
/*void updateClient(Client client);
void deleteClient(Client client);*/
int validateClients(String client_Name,String client_Password);
}
