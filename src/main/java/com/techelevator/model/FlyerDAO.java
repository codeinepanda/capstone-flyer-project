package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface FlyerDAO {
	public void createFlyer(Flyer newflyer);
	public ArrayList<Flyer> getFeaturedFlyers();
	public List<Flyer> getAllFlyersByCreator(String userName);
	public ArrayList<Flyer> selectAllNotExpired(LocalDate endDate);
	public ArrayList<Flyer> getFlyersFiltered(String userName, String category, String flyerName, String company,
			String order);
	public String pullTab(int flyerID);
	public ArrayList<Flyer> getFlyersFromUnredeemedTabsByUser(String userName);
	public void retireAFlyer(int flyerID);
}
