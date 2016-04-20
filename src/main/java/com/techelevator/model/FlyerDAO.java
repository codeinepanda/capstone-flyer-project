package com.techelevator.model;

import java.util.ArrayList;

public interface FlyerDAO {
	public void createFlyer(Flyer newflyer);
	public ArrayList<Flyer> getFeaturedFlyers();
	public ArrayList<Flyer> getFilteredFlyers();
}
