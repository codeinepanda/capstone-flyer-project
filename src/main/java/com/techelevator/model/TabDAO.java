package com.techelevator.model;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public interface TabDAO {
	public void pullNewTab(String userName, int flyerID) throws SQLException;
	public void redeemTab(String userName, int flyerID);
}
