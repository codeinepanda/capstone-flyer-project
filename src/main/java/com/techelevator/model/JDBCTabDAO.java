package com.techelevator.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
		Object[] params = {false, flyerID, userName};
		String sqlCreateTab = "INSERT INTO tab(isredeemed, flyer_id, user_name) VALUES(?,?,?);";
		jdbcTemplate.update(sqlCreateTab, params);
	}

	@Override
	public void redeemTab(String userName, int flyerID) {
		Object[] params = {userName, flyerID};
		String sqlRedeemTab = "UPDATE tab" +
							  "SET isredeemed = 1" +
							  "WHERE user_name = ? AND flyer_id = ?;";
		jdbcTemplate.update(sqlRedeemTab, params);
	}

}
