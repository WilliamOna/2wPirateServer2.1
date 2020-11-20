package com.revature.pirate.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pirate.dao.DatabasePirateDAO;
import com.revature.pirate.dao.DatabaseRoleDAO;
import com.revature.pirate.exception.RoleNotFoundException;
import com.revature.pirate.model.Pirate;
import com.revature.pirate.model.Role;
import com.revature.pirate.template.InsertPirateTemplate;

public class PirateService {
	
	private DatabasePirateDAO pirateDAO;
	private DatabaseRoleDAO roleDAO;
	
	public PirateService() {
		this.pirateDAO = new DatabasePirateDAO();
		this.roleDAO = new DatabaseRoleDAO();
	}
	
	// Generally this constructor is for doing unit testing
	// You should basically mock the DatabasePirateDAO object, and then pass it into the PirateService object
	// In order to simulate an actual database
	// So when you're unit testing, generally you should not actually be using the actual database, and instead you should
	// mock returns from the dao layer to the service layer
	
	// Look into using Mockito
	// There should definitely be a lot of articles about mocking DAOs
	public PirateService(DatabasePirateDAO pirateDAO, DatabaseRoleDAO roleDAO) {
		this.pirateDAO = pirateDAO;
		this.roleDAO = roleDAO;
	}
	
	public ArrayList<Pirate> getAllPirates() {
		// If you have additional you want to add later, you can easily do it by something like this
		return pirateDAO.getAllPirates();
	}
	
	public Pirate insertPirates(InsertPirateTemplate pirateTemplate) throws RoleNotFoundException {
		// What we want to accomplish is taking the pirate name, and role name
		// and then calling the RoleDAO to get an actual role corresponding to that role name,
		// Once we do that, we will know what the role id is, and then we can actually insert
		// the pirate into the pirate table (name, role_id)
		Role role;
		role = roleDAO.findRoleByName(pirateTemplate.getRole_name());
		
		if (role == null) {
			throw new RoleNotFoundException("The user attempted to insert a pirate for a role that does not exist");
		}
		
		return pirateDAO.insertPirate(pirateTemplate.getName(), role);
	}
	
//	public void showPirates(ArrayList<Pirate> pirates) {
//		for (Pirate pirate : pirates) {
//			System.out.println(pirate);
//		}
//	}
//	
//	public int search(ArrayList<Pirate> pirates, String name) {
//		int index = -1;
//		for(Pirate pirate:pirates) {
//			index++;
//			if(pirate.getName().equals(name)) {
//				return index;
//			}
//		}
//		return -1;
//		
//	}
//	
//	public Pirate setPirate(ArrayList<Pirate> pirates, String name, String role){
//		// Set Role of Pirate
//				int index = this.search(pirates, name);
//				if(index == -1) {
//					System.out.println("Pirate not found Exception"); // we could make our own exception
//					return null;
//				}else {
//
//					pirates.get(index).setRole(role);
//					return pirates.get(index);
//				}
//	}
}
