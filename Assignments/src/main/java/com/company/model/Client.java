package com.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	@Id@GeneratedValue
	private int client_Id;
	private String client_Name;
	private String client_Address;
	private String client_Password;
public int getClient_Id() {
		return client_Id;
	}
	public void setClient_Id(int client_Id) {
		this.client_Id = client_Id;
	}
	public String getClient_Name() {
		return client_Name;
	}
	public void setClient_Name(String client_Name) {
		this.client_Name = client_Name;
	}
	public String getClient_Address() {
		return client_Address;
	}
	public void setClient_Address(String client_Address) {
		this.client_Address = client_Address;
	}
	
	public String getClient_Password() {
		return client_Password;
	}
	public void setClient_Password(String client_Password) {
		this.client_Password = client_Password;
	}
	

}
