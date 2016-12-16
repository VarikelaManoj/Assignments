package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.dao.ClientDao;
import com.company.model.Client;
@RestController
public class ClientController {
	@Autowired
	ClientDao clientDao;
	@RequestMapping(value="/addClient",headers="Accept=Application/json",method=RequestMethod.POST)
	public void addClient(@RequestBody Client client)
	{
		clientDao.addClient(client);
		System.out.println("addclients:"+client);
	}
	@RequestMapping(value="/authenticateClient",headers="Accept=Application/json",method=RequestMethod.POST)
	public int authenticateClient(@RequestBody Client client)
	{
		System.out.println("client_Name"+client.getClient_Name());
		System.out.println("client_Password"+client.getClient_Password());
		int result=0;
		result=clientDao.validateClients(client.getClient_Name(), client.getClient_Password());
		System.out.println("result"+result);
		return result;
	}
	@RequestMapping(value = "/viewClients", method = RequestMethod.GET, headers = "Accept=application/json")  
	public List<Client> viewClients()
	{
		 List<Client> clients=clientDao.viewClients();
		return clients;
	}
}
