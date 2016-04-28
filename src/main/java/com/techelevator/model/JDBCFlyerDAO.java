package com.techelevator.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

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
	public ArrayList<String> getAllUniqueValuesFromFlyer(String column) {
		ArrayList<String> values = new ArrayList();
		String sqlAllCategories = "SELECT DISTINCT " + column + " FROM flyer;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllCategories);
		while(results.next()) {
			values.add(results.getString(column));
		}
		return values;
	}
	
	@Override
	public ArrayList<String> getAllUniqueValuesFromCategory() {
		ArrayList<String> values = new ArrayList();
		String sqlAllCategories = "SELECT DISTINCT category FROM category;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllCategories);
		while(results.next()) {
			values.add(results.getString("category"));
		}
		return values;
	}
	
	@Override
	public ArrayList<Flyer> getFeaturedFlyers() {
		ArrayList<Flyer> featuredFlyersList = new ArrayList<>();
		Date today = Date.valueOf(LocalDate.now());
		Object[] params = {today, false, 0};
		String sqlSelectFeaturedFlyers = "SELECT * FROM flyer " +
										 "WHERE end_date > ? AND isRetired = ? AND num_tabs > ?" +
										 "ORDER BY create_date LIMIT 6";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectFeaturedFlyers, params);
		
		while (results.next()) {
			featuredFlyersList.add(getFlyerFromDB(results));
		}
		return featuredFlyersList;
	}

	@Override
	public ArrayList<Flyer> getFlyersFiltered(String userName,String category, String flyerName, String company, String order) {
		String[] categories = category.split(Pattern.quote(","));
		ArrayList<Flyer> filteredFlyersList = new ArrayList<>();
		String sqlGetFilteredFlyerList = "SELECT * FROM flyer ";
		if(!categories[0].equals("") && order.equals("(SELECT COUNT(*) FROM tab WHERE tab.flyer_id = flyer.flyer_id)")) {
			sqlGetFilteredFlyerList += "JOIN tab ON flyer.flyer_id = tab.flyer_id JOIN category ON flyer.flyer_id = category.flyer_id WHERE ";
			if(categories.length == 1) {
				sqlGetFilteredFlyerList += "category.category = '" + categories[0] + "' ";
				System.out.println(categories[0]);
			} else {
				for(int i = 0; i < categories.length -1; i++) {
					System.out.println("Category i: " + categories[i]);
					sqlGetFilteredFlyerList += "category.category = '" + categories[i] + "' OR ";
				}
				sqlGetFilteredFlyerList += "category.category = '" + categories[categories.length - 1] + "' ";
			}
		} else if(!categories[0].equals("")) {
			sqlGetFilteredFlyerList += "JOIN category ON flyer.flyer_id = category.flyer_id WHERE ";
			if(categories.length == 1) {
				sqlGetFilteredFlyerList += "category.category = '" + categories[0] + "' ";
				System.out.println(categories[0]);
			} else {
				for(int i = 0; i < categories.length -1; i++) {
					System.out.println("Category i: " + categories[i]);
					sqlGetFilteredFlyerList += "category.category = '" + categories[i] + "' OR ";
				}
				sqlGetFilteredFlyerList += "category.category = '" + categories[categories.length - 1] + "' ";
			}
		} else if(order.equals("(SELECT COUNT(*) FROM tab WHERE tab.flyer_id = flyer.flyer_id)")){
			sqlGetFilteredFlyerList += "JOIN tab ON flyer.flyer_id = tab.flyer_id WHERE ";
		} else {
			sqlGetFilteredFlyerList += "WHERE ";
		}
		if(!userName.equals("")) {
			sqlGetFilteredFlyerList += "UPPER(flyer.user_name) = '" + userName + "' ";
		} else if(!flyerName.equals("")) {
			sqlGetFilteredFlyerList += "UPPER(flyer.flyer_name) = '" + flyerName + "' ";
		} else if(!company.equals("")) {
			sqlGetFilteredFlyerList += "UPPER(flyer.company) = '" + company + "' ";
		}
		sqlGetFilteredFlyerList += "ORDER BY " + order + ";";
		System.out.println("full sql statement: " + sqlGetFilteredFlyerList);
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetFilteredFlyerList);
		while (results.next())
		{
			filteredFlyersList.add(getFlyerFromDB(results));
		}
		return filteredFlyersList; 
	}

	@Override
	public void createFlyer(Flyer newFlyer) {
		int flyerID = 0;
		Date startDate = Date.valueOf(newFlyer.getStartDate());
		Date endDate = Date.valueOf(newFlyer.getEndDate());
		Date createDate = Date.valueOf(newFlyer.getCreateDate());
		Object[] params = {newFlyer.getCompany(), newFlyer.getUserName(), newFlyer.getFlyerName(), createDate, startDate, endDate, newFlyer.getNumberOfTabs(), newFlyer.getFlyerDescription()};
		String sqlCreateNewFlyer = "INSERT INTO flyer(company, user_name, flyer_name, create_date, start_date, end_date, num_tabs, flyer_info) VALUES (?,?,?,?,?,?,?,?);";
		jdbcTemplate.update(sqlCreateNewFlyer, params);
		String sqlGetIdFromNewFlyer = "SELECT flyer_id FROM flyer WHERE company = ? AND user_name = ? AND flyer_name = ? AND create_date = ? AND start_date = ? AND end_date = ? AND num_tabs = ? AND flyer_info = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetIdFromNewFlyer, params);
		while(results.next()) {
			flyerID = results.getInt("flyer_id");
		}
		for(String str : newFlyer.getCategories()) {
			String sqlAddCategory = "INSERT INTO category(category, flyer_id) VALUES (?,?)";
			Object[] categoryParams = {str, flyerID};
			jdbcTemplate.update(sqlAddCategory, categoryParams);
		}
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
	
	// ------- SUB-METHODS FOR INTERNAL USE BY INTERFACE-DEFINED METHODS
	
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
		newFlyer.setFlyerDescription(results.getString("flyer_info"));
		newFlyer.setRetired(results.getBoolean("isRetired"));
		String sqlGetCategories = "SELECT * FROM category WHERE flyer_id = ?;";
		SqlRowSet categoryResults = jdbcTemplate.queryForRowSet(sqlGetCategories, newFlyer.getFlyerID());
		while(categoryResults.next()) {
			newFlyer.getCategories().add(categoryResults.getString("category"));
		}
		return newFlyer;
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
	
	
	

}