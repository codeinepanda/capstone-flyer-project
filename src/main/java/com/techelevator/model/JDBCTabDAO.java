package com.techelevator.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCTabDAO implements TabDAO{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCTabDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void pullNewTab(String userName, int flyerID) {
		boolean isredeemed = false;
		Object[] params = {userName, flyerID, isredeemed};
		String sqlCreateTab = "INSERT INTO tab VALUES(?,?,?);";
		jdbcTemplate.update(sqlCreateTab, params);
		
	}

	@Override
	public void redeemTab(String userName, int flyerID) {
		Object[] params = {userName, flyerID};
		String sqlRedeemTab = "UPDATE tab" +
							  "SET isredeemed = true" +
							  "WHERE user_name = ? AND flyer_id = ?;";
		jdbcTemplate.update(sqlRedeemTab, params);
	}

}
