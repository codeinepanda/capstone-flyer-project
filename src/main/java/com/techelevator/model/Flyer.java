package com.techelevator.model;

import java.time.LocalDateTime;

public class Flyer {

	private int flyerID;
	private int userID;
	private String flyerName;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int numberOfTabs;
	private String flyerDescription;
	
	
	
	public int getFlyerID() {
		return flyerID;
	}
	public void setFlyerID(int flyerID) {
		this.flyerID = flyerID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFlyerName() {
		return flyerName;
	}
	public void setFlyerName(String flyerName) {
		this.flyerName = flyerName;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public int getNumberOfTabs() {
		return numberOfTabs;
	}
	public void setNumberOfTabs(int numberOfTabs) {
		this.numberOfTabs = numberOfTabs;
	}
	public String getFlyerDescription() {
		return flyerDescription;
	}
	public void setFlyerDescription(String flyerDescription) {
		this.flyerDescription = flyerDescription;
	}
	
}
	
