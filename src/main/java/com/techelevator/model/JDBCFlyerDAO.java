package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCFlyerDAO implements FlyerDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCFlyerDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public ArrayList<Flyer> getFeaturedFlyers() {
		ArrayList<Flyer> featuredFlyersList = new ArrayList<>();
		Date today = Date.valueOf(LocalDate.now());
		Object[] params = {today, false};
		String sqlSelectFeaturedFlyers = "SELECT * FROM flyer " +
										 "WHERE end_date < ? AND isRetired = ? " +
										 "ORDER BY create_date LIMIT 6";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectFeaturedFlyers);
		
		while (results.next()) {
			featuredFlyersList.add(getFlyerFromDB(results));
		}
		return featuredFlyersList;
	}

	@Override
	public ArrayList<Flyer> getFlyersFiltered(String userName,String category, String flyerName, String company, String order) {
		ArrayList<Flyer> filteredFlyersList = new ArrayList<>();
		Object[] params = {userName, category, flyerName, company, userName, category, userName, flyerName, userName, company, flyerName, category, flyerName, company, category, company, 
											userName, category, flyerName, userName, category, company, userName, flyerName, company, flyerName, category, company, userName, category, flyerName, company, order};
		
		
		String sqlFilteredFlyersList = "SELECT * FROM flyer WHERE user_name = ? OR category = ? OR flyer_name = ? OR company = ?" 
									+ " OR (user_name = ? AND category = ?) OR (user_name = ? AND flyer_name = ?) OR (user_name = ? AND company = ?) OR (flyer_name = ? AND category = ?) OR (flyer_name = ? AND company = ?) OR (category = ? AND company = ?)"
									+ " OR (user_name = ? AND category = ? AND flyer_name = ?) OR (user_name = ? AND category = ? AND company = ?) OR (user_name = ? AND flyer_name = ? AND company = ?) OR (flyer_name = ? AND category = ? AND company = ?)"	
									+ " OR (user_name = ? AND category = ? AND flyer_name = ? AND company = ?) ORDER BY ? DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFilteredFlyersList, params);
		while (results.next())
		{
			filteredFlyersList.add(getFlyerFromDB(results));
		}
		return filteredFlyersList; 
	}

	@Override
	public void createFlyer(Flyer newFlyer) {
		Date startDate = Date.valueOf(newFlyer.getStartDate());
		Date endDate = Date.valueOf(newFlyer.getEndDate());
		Date createDate = Date.valueOf(newFlyer.getCreateDate());
		Object[] params = {newFlyer.getCompany(), newFlyer.getUserName(), newFlyer.getFlyerName(), createDate, startDate, endDate, newFlyer.getNumberOfTabs(), newFlyer.getFlyerDescription(), newFlyer.getCategory()};
		String sqlCreateNewFlyer = "INSERT INTO flyer(company, user_name, flyer_name, create_date, start_date, end_date, num_tabs, flyer_info, category) VALUES (?,?,?,?,?,?,?,?,?);";
		jdbcTemplate.update(sqlCreateNewFlyer, params);
	}

	@Override
	public List<Flyer> getAllFlyersByCreator(String userName) {
	ArrayList<Flyer> flyerUserList = new ArrayList<>();
	String sqlSelectUserFlyers = "SELECT * FROM flyer WHERE user_name = ?";
	
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectUserFlyers, userName);
	
	while (results.next())
	{
		flyerUserList.add(getFlyerFromDB(results));
	}
	return flyerUserList;
}

	@Override
	public ArrayList<Flyer> selectAllNotExpired(LocalDate endDate) {
		String sqlSelectNotExpiredFlyers = "SELECT *"+
										"FROM flyer;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNotExpiredFlyers);
		ArrayList<Flyer> activeFlyers = new ArrayList<Flyer>();

			for(int i = 0; results.next(); i++) {
				Flyer checkFlyer = (Flyer) results.getObject(i);
				if(isActive(checkFlyer.getEndDate())) {
					activeFlyers.add(checkFlyer);
				}
			}
			return activeFlyers;
	}

	@Override
	public ArrayList<Flyer> getFlyersFromUnredeemedTabsByUser(String userName) {
		ArrayList<Flyer> listOfUnredeemedTabs = new ArrayList<>();
		String sqlListOfUnredeemedTabs = "SELECT * FROM flyer JOIN tab ON tab.flyer_id = flyer.flyer_id WHERE isRedeemed = false AND tab.user_name = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListOfUnredeemedTabs, userName);
		while (results.next()) {
		listOfUnredeemedTabs.add(getFlyerFromDB(results));	
		}
		return listOfUnredeemedTabs;
		}
	
	public boolean isActive(LocalDate endDate) {
		LocalDate today = LocalDate.now();
		int daysRemaining = (int)ChronoUnit.DAYS.between(today, endDate);
		if(daysRemaining > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private Flyer getFlyerFromDB(SqlRowSet results) {
		LocalDate create = results.getDate("create_date").toLocalDate();
		LocalDate start = results.getDate("start_date").toLocalDate();
		LocalDate end = results.getDate("end_date").toLocalDate();
		Flyer newFlyer = new Flyer();
		newFlyer.setFlyerID(results.getInt("flyer_id"));
		newFlyer.setTabsTaken(results.getInt("tabs_taken"));
		newFlyer.setUserName(results.getString("user_name"));
		newFlyer.setCompany(results.getString("company"));
		newFlyer.setFlyerName(results.getString("flyer_name"));
		newFlyer.setCreateDate(create);
		newFlyer.setStartDate(start);
		newFlyer.setEndDate(end);
		newFlyer.setNumberOfTabs(results.getInt("num_tabs")); 
		newFlyer.setCategory(results.getString("category"));
		newFlyer.setFlyerDescription(results.getString("flyer_info"));
		return newFlyer;
	}
	
	@Override
	public String pullTab(int flyerID) {
		String message = "";
		if(hasAtLeastOneTab(flyerID)) {
			message = "Congratulations! You've successfully pulled a tab from this flyer! Be sure to redeem it before the offer expires!";
			Object[] params ={flyerID};
			String sqlPullTabQuery = "Update flyer " +
								 	 "SET num_tabs = num_tabs - 1, tabs_taken = tabs_taken + 1 " +
								 	 "WHERE flyer_id = ?;";
			jdbcTemplate.update(sqlPullTabQuery, params);
		} else {
			message = "Sorry, there aren't any tabs left on this flyer! But don't let that discourage you! Have a look through our other " +
					  "flyers on this site and find another offer that's right for you!";
		}
		return message;
	}
	
	public boolean hasAtLeastOneTab(int flyerID) {
		int numTabs = 0;
		String sqlCheckIfTabsRemain = "SELECT num_tabs FROM flyer WHERE flyer_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCheckIfTabsRemain, flyerID);
		while(results.next()) {
			numTabs = results.getInt("num_tabs");
		}
		if(numTabs > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void retireAFlyer(int flyerID) {
		LocalDate today= LocalDate.now();
		Date newExpirationDate = Date.valueOf(today);
		String sqlRetireFlyer = "UPDATE flyer " +
								"SET num_tabs = 0, end_date = ?, isRetired = ? " +
								"WHERE flyer_id = ?;";
		Object[] params = {newExpirationDate, true, flyerID};
		jdbcTemplate.update(sqlRetireFlyer, params);
	}
	
	
	

}