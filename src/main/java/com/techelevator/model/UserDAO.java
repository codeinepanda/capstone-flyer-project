package com.techelevator.model;

public interface UserDAO {
	
	public void saveUser(String firstName, String lastName, String password, int userID, String email);

	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

}



