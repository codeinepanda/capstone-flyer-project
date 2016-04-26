package com.techelevator.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCTabDAO implements TabDAO{
	private JdbcTemplate jdbcTemplate;
	private FlyerDAO flyerDAO;
	
	@Autowired
	public JDBCTabDAO(FlyerDAO flyerDAO, DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.flyerDAO = flyerDAO;
	}
	
	@Override
	public void generateNewTab(String userName, int flyerID) {
		Date pullDate = Date.valueOf(LocalDate.now());
		Object[] params = {false, pullDate, flyerID, userName};
		String sqlCreateTab = "INSERT INTO tab(isRedeemed, pull_date, flyer_id, user_name) VALUES(?,?,?,?);";
		jdbcTemplate.update(sqlCreateTab, params);
	}

	@Override
	public void redeemTab(String userName, int flyerID) {
		Date pullDate = Date.valueOf(LocalDate.now());
		Object[] params = {true, flyerID, userName};
		String sqlRedeemTab = "UPDATE tab " +
							  "SET isRedeemed = ?" +
							  "WHERE flyer_id = ? AND user_name = ?;";
		jdbcTemplate.update(sqlRedeemTab, params);
	}
	
	@Override
	public int getNumAllowableTabs(String userName) {
		int numAllowableTabs = 0;
		Date mostRecentExpire = getMostRecentlyExpiredTabFromUser(userName);
		Object[] paramsRedeemed = {userName, true, mostRecentExpire};
		String sqlNumRedeemTabs = "SELECT COUNT(*) FROM tab " +
								  "JOIN flyer ON tab.flyer_id = flyer.flyer_id " +
								  "WHERE tab.user_name = ? AND tab.isRedeemed = ? AND tab.pull_date > ?;";
		SqlRowSet redeemedResults = jdbcTemplate.queryForRowSet(sqlNumRedeemTabs, paramsRedeemed);
		while(redeemedResults.next()) {
			numAllowableTabs = redeemedResults.getInt("count");
		}
		if(numAllowableTabs > 1) {
			return numAllowableTabs;
		} else {
			numAllowableTabs = 1;
			return numAllowableTabs;
		}
	}
	
	@Override
	public int getNumUnredeemedTabsFromUser(String userName) {
		int numUnredeemedTabs = 0;
		Date today = Date.valueOf(LocalDate.now());
		Object[] params = {userName, false, today};
		String sqlUnredeemedTabs = "SELECT COUNT(*) FROM tab " +
				 				   "JOIN flyer ON tab.flyer_id = flyer.flyer_id " +
				 				   "WHERE tab.user_name = ? AND tab.isRedeemed = ? AND flyer.end_date > ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlUnredeemedTabs, params);
		while(results.next()) {
			numUnredeemedTabs = results.getInt("count");
		}
		return numUnredeemedTabs;
	}

	public Date getMostRecentlyExpiredTabFromUser(String userName) {
		ArrayList<Date> datesToCheck = new ArrayList();
		Date mostRecentExpire = Date.valueOf("1000-01-01");
		Object[] paramsRecent = {userName};
		String sqlMostRecentExpiredTab = "SELECT end_date FROM flyer " +
										 "JOIN tab ON flyer.flyer_id = tab.flyer_id AND tab.user_name = ?;";
		SqlRowSet expirationResults = jdbcTemplate.queryForRowSet(sqlMostRecentExpiredTab, paramsRecent);
		while(expirationResults.next()) {
			Date checkDate = expirationResults.getDate("end_date");
			datesToCheck.add(checkDate);
		}
		for(Date exp : datesToCheck) {
			if(exp.after(mostRecentExpire)) {
				mostRecentExpire.valueOf(exp.toLocalDate());
			}
		}
		return mostRecentExpire;
	}

	@Override
	public ArrayList<Tab> getTabsByHolder(String username) {
		ArrayList<Tab> unredeemedTabs = new ArrayList();
		ArrayList<Flyer> flyers = flyerDAO.getFlyersFromUnredeemedTabsByUser(username);
		for(Flyer flyer : flyers) {
			Tab tab = new Tab(username, flyer.getFlyerID(), false, flyer.getStartDate(), flyer.getEndDate(), flyer.getFlyerName());
			unredeemedTabs.add(tab);
		}
		return unredeemedTabs;
	}

	@Override
	public void redeemAllTabsByFlyer(int flyerID) {
		Object[] params = {flyerID};
		String sqlRedeemTab = "UPDATE tab " +
							  "SET isRedeemed = true " +
							  "WHERE flyer_id = ?;";
		jdbcTemplate.update(sqlRedeemTab, params);	
	}

}
