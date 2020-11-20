package com.revature.pirate.template;

public class InsertPirateTemplate {

	private String name;
	private String role_name;
	
	public InsertPirateTemplate() {
		super();
	}
	
	public InsertPirateTemplate(String name, String role_name) {
		this.name = name;
		this.role_name = role_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "InsertPirateTemplate [name=" + name + ", role_name=" + role_name + "]";
	}
}
