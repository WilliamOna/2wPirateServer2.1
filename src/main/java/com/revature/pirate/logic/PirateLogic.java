package com.revature.pirate.logic;

import java.util.ArrayList;

import com.revature.pirate.model.Pirate;

public class PirateLogic {
	public void showPirates(ArrayList<Pirate> pirates) {
		for (Pirate pirate : pirates) {
			System.out.println(pirate);
		}
	}
	
	public int search(ArrayList<Pirate> pirates, String name) {
		int index = -1;
		for(Pirate pirate:pirates) {
			index++;
			if(pirate.getName().equals(name)) {
				return index;
			}
		}
		return -1;
		
	}
	
	public Pirate setPirate(ArrayList<Pirate> pirates, String name, String role){
		// Set Role of Pirate
				int index = this.search(pirates, name);
				if(index == -1) {
					System.out.println("Pirate not found Exception"); // we could make our own exception
					return null;
				}else {

					pirates.get(index).setRole(role);
					return pirates.get(index);
				}
	}
}
