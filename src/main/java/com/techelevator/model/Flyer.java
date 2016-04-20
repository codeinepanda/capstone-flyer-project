package com.techelevator.model;

import java.time.LocalDate;

public class Flyer {

	private int flyerID;
	private String userName;
	private String flyerName;
	private LocalDate startDate;
	private LocalDate endDate;
	private int numberOfTabs;
	private String flyerDescription;
	
	
	
	public int getFlyerID() {
		return flyerID;
	}
	public void setFlyerID(int flyerID) {
		this.flyerID = flyerID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserID(String userName) {
		this.userName = userName;
	}
	public String getFlyerName() {
		return flyerName;
	}
	public void setFlyerName(String flyerName) {
		this.flyerName = flyerName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
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
	
