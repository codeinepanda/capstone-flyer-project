package com.techelevator.model;

import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.time.LocalDateTime;
>>>>>>> 66c39a6a13b5e6f9f0aa2fcf7451392f85f49911

public class Flyer {

	private int flyerID;
	private String userName;
	private String company;
	private String flyerName;
	private LocalDate startDate;
	private LocalDate endDate;
	private int numberOfTabs;
	private String category;
	private String flyerDescription;
	
	public Flyer(String userName, String company, String flyerName, LocalDate startDate, LocalDate endDate, int numTabs, String category, String flyerDescription) {
		this.userName = userName;
		this.company = company;
		this.flyerName = flyerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfTabs = numTabs;
		this.category = category;
		this.flyerDescription = flyerDescription;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getFlyerID() {
		return flyerID;
	}
	public void setFlyerID(int flyerID) {
		this.flyerID = flyerID;
	}
	public String getUserName() {
		return userName;
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
