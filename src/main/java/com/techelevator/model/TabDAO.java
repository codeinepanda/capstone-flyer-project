package com.techelevator.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public interface TabDAO {
	public void pullNewTab(String userName, int flyerID);
	public void redeemTab(String userName, int flyerID);
	public ArrayList<Tab> getTabsByHolder(String username);
	public void redeemAllTabsByFlyer(int flyerID);
	public int getNumAllowableTabs(String userName);
	public int getNumUnredeemedTabsFromUser(String userName);
}
