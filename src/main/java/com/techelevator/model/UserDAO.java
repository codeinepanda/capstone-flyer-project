package com.techelevator.model;

import java.util.HashMap;

public interface UserDAO {
	
	public void createUser(User newUser);

	public User returnUserByUsername(String userName);
	
	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);
	
	public void createUserPreferences(String user, String company, String author, String categories);
	
	public boolean preferencesExist(String username);
	
	public void updateUserPreferences(String user, String company, String author, String categories);
	
	public HashMap<String, String> getUserPreferences(String username);

	boolean canTakeTab(String userName, int flyerID);

}



