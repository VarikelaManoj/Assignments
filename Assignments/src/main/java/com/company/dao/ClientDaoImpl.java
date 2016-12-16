package com.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.Client;
@Transactional
@Repository
public class ClientDaoImpl implements ClientDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addClient(Client client) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(client);
	}
	public int validateClients(String client_Name, String client_Password) {
		// TODO Auto-generated method stub
		int res=0;
		Session session=sessionFactory.getCurrentSession();
	 Query result=session.createQuery("from Client c where c.client_Name='"+client_Name+"'");
		List<Client> clients=result.list();
		System.out.println("clients"+clients);
		if(clients.size()==0)
		{
			res=0;
		}
		else
		{
			for(int i=0;i<clients.size();i++)
			{
				System.out.println("inside for loop");
				String dbclientName=clients.get(i).getClient_Name();
				String dbpassword=clients.get(i).getClient_Password();
				if(dbclientName.equals(client_Name)&&dbpassword.equals(client_Password))
				{
					res=1;
					System.out.println("the result is:"+res);
				}
				else
				{
				res=2;
				System.out.println("incorrect username and password"+res);
				}
		}
		}		
	 return res;
	
	}

	/*public int validateUsers(String username, String password) {
		int res=0;
		Session session=sessionFactory.getCurrentSession();
		Query result = session.createQuery("from Users  u where u.username='"+username+"'");
		List<Users> users=result.list();
		System.out.println("users:"+users);
		if(users.size()==0)
		{
			res=0;
		}
		else
		{
			for(int i=0;i<users.size();i++)
			{
				System.out.println("inside for loop");
				String dbuserName=users.get(i).getUsername();
				String dbpassword=users.get(i).getPassword();
				String dbrole=users.get(i).getRole();
				if(dbuserName.equals(username)&&dbpassword.equals(password)&&dbrole.equals("ROLE_USER"))
				{
					res=1;
					System.out.println("the result is:"+res);
				}
				else
					if(dbuserName.equals(username)&&dbpassword.equals(password)&&dbrole.equals("ROLE_ADMIN"))
				{
					res=2;
					System.out.println("the result  is:"+res);
				}
				}
		}	
		return res;
		}
	}
	*/
	
	public List<Client> viewClients() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<Client> list=session.createCriteria(Client.class).list();
		return list;
	}
	}
	/*public void updateClient(Client client) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(client);
		
	}

	public void deleteClient(Client client) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(client);
		
	}

	public int validateClients(String client_name, String client_password) {
		// TODO Auto-generated method stub
		return 0;
	}
*/

