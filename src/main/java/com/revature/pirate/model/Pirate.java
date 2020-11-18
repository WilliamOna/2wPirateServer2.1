package com.revature.pirate.model;
public class Pirate{ //implements Serializeable
	private String name; //instance
	private String role;
	
	public Pirate(){
		this.name = "Unknown Pirate";
		this.role = "Landlubber";
	}
	
	public Pirate(String name, String role){
		this.name = name;
		this.role = role;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){ // method scope
		this.name = name;
	}
	
	public String getRole(){
		return this.role;
	}
	
	public void setRole(String role){ // method scope
		this.role = role;
	}
	
	@Override
	public String toString(){
		return "Aaaarg! I am: " + this.name + ". I have been cursed with the role of: " + this.role;
	}
	//hashCode()
	//equals()
}