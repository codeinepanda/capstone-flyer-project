package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface FlyerDAO {
	public void createFlyer(Flyer newflyer);
	public ArrayList<Flyer> getFeaturedFlyers();
	public List<Flyer> getAllFlyersByCreator(String userName);
<<<<<<< HEAD
	public ArrayList<Flyer> selectAllNotExpired(LocalDate endDate);
	public ArrayList<Flyer> getFlyersFiltered(String userName, String category, String flyerName, String company,
			boolean mostPopular);
	
=======
	ArrayList<Flyer> selectAllNotExpired(LocalDate endDate);
	public String pullTab();
>>>>>>> 228cefc2c5c219fe64111b05ae4eaa1147277f77
}
