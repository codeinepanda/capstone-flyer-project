package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface FlyerDAO {
	public void createFlyer(Flyer newflyer);
	public ArrayList<Flyer> getFeaturedFlyers();
	public ArrayList<Flyer> getFilteredFlyers();
	public List<Flyer> getAllFlyersForUser(String userName);
	ArrayList<Flyer> selectAllNotExpired(LocalDate endDate);
}
