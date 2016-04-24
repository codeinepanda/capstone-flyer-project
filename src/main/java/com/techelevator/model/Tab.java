package com.techelevator.model;

public class Tab {
	private String userName;
	private int flyerID;
	private boolean isRedeemed;
	
	public Tab(String userName, int flyerID) {
		this.userName = userName;
		this.flyerID = flyerID;
		this.isRedeemed = false;
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
	
	
}
