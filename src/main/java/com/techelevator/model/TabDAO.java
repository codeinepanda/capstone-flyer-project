package com.techelevator.model;

public interface TabDAO {
	public void pullNewTab(String userName, int flyerID);
	public void redeemTab(String userName, int flyerID);
}
