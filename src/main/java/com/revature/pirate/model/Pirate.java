package com.revature.pirate.model;
public class Pirate{ //implements Serializeable
	
	private int id;
	private String name; //instance
	private Role role;
	
	public Pirate(String name, Role role){
		this.name = name;
		this.role = role;
	}
	
	public Pirate(int id, String name, Role role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){ // method scope
		this.name = name;
	}
	
	public Role getRole(){
		return this.role;
	}
	
	public void setRole(Role role){ // method scope
		this.role = role;
	}
	
	@Override
	public String toString(){
		return "Aaaarg! I have an ID of " + this.id + ". I am: " + this.name + ". I have been cursed with the role of: " + this.role;
	}
	//hashCode()
	//equals()
}