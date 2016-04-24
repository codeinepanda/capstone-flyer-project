package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;

public class Tab {
	private String userName;
	private int flyerID;
	private boolean isRedeemed;
	private LocalDate startDate;
	private LocalDate endDate;
	private String flyerName;
	
	public Tab(String userName, int flyerID) {
		this.userName = userName;
		this.flyerID = flyerID;
		this.isRedeemed = false;
	}
	
	public Tab(String userName, int flyerID, boolean isRedeemed, LocalDate localDate, LocalDate localDate2, String flyerName) {
		this.userName = userName;
		this.flyerID = flyerID;
		this.isRedeemed = isRedeemed;
		this.startDate = localDate;
		this.endDate = localDate2;
		this.flyerName = flyerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getFlyerID() {
		return flyerID;
	}

	public void setFlyerID(int flyerID) {
		this.flyerID = flyerID;
	}

	public boolean isRedeemed() {
		return isRedeemed;
	}

	public void setRedeemed(boolean isRedeemed) {
		this.isRedeemed = isRedeemed;
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

	public String getFlyerName() {
		return flyerName;
	}

	public void setFlyerName(String flyerName) {
		this.flyerName = flyerName;
	}
}
