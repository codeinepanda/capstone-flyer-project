package com.techelevator.model;

import java.util.ArrayList;

public interface FlyerDAO {
	public ArrayList<Flyer> getFeaturedFlyers();
	public ArrayList<Flyer> getFilteredFlyers();
}
