package com.techelevator.model;

import java.sql.Date;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Flyer> getFilteredFlyers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFlyer(Flyer newFlyer) {
		Date startDate = Date.valueOf(newFlyer.getStartDate());
		Date endDate = Date.valueOf(newFlyer.getEndDate());
		Object[] params = {newFlyer.getCompany(), newFlyer.getUserName(), newFlyer.getFlyerName(), startDate, endDate, newFlyer.getNumberOfTabs(), newFlyer.getFlyerDescription(), newFlyer.getCategory()};
		String sqlCreateNewFlyer = "INSERT INTO flyer(company, user_name, flyer_name, start_date, end_date, num_tabs, flyer_info, category) VALUES (?,?,?,?,?,?,?,?);";
		jdbcTemplate.update(sqlCreateNewFlyer, params);
	}

	@Override
	public ArrayList<Flyer> getAllFlyersForUser() {
		
		return null;
	}

}
