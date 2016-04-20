package com.techelevator.model;

import java.util.ArrayList;

public class User {
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private ArrayList<Object> pulledTabs;
	
	public User(String first, String last, String username, String email, String pwd) {
		this.firstName = first;
		this.lastName = last;
		this.username = username;
		this.email = email;
		this.password = pwd;
	}
	
	public User(String first, String last, String username, String email) {
		this.firstName = first;
		this.lastName = last;
		this.username = username;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Object> getPulledTabs() {
		return pulledTabs;
	}

	public void setPulledTabs(ArrayList<Object> pulledTabs) {
		this.pulledTabs = pulledTabs;
	}
	
	
}
