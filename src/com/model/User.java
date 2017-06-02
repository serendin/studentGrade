package com.model;

public class User {
	private String useid;
	private String password;
	private String name;
	private String type;

	public User(){}
	public User(String useid, String password, String name, String type) {
		super();
		this.useid = useid;
		this.password = password;
		this.name = name;
		this.type = type;
	}

	public String getUseid() {
		return useid;
	}

	public void setUseid(String useid) {
		this.useid = useid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
