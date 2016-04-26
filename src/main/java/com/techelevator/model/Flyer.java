package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Flyer {

	private int flyerID;
	private String userName;
	private String company;
	private String flyerName;
	private LocalDate startDate;
	private LocalDate endDate;
	private int numberOfTabs;
	private ArrayList<String> categories = new ArrayList();
	private String flyerDescription;
	private LocalDate createDate;
	private int tabsTaken;
	private boolean retired;
	
	
	public Flyer(String userName, String company, String flyerName, LocalDate startDate, LocalDate endDate, int numTabs, String flyerDescription, boolean isRetired) {
		this.userName = userName;
		this.company = company;
		this.flyerName = flyerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfTabs = numTabs;
		this.flyerDescription = flyerDescription;
		this.retired = isRetired;
	}
	public Flyer() {
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public ArrayList<String> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
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
	public int getTabsTaken() {
		return tabsTaken;
	}
	public void setTabsTaken(int tabsTaken) {
		this.tabsTaken = tabsTaken;
	}
	public boolean isRetired() {
		return retired;
	}
	public void setRetired(boolean retired) {
		this.retired = retired;
	}
	

	
}
	
