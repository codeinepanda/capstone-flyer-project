package com.techelevator.model;

public interface UserDAO {
	
	public void createUser(User newUser);

	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

}



