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
	private DataSource datasource;
	
	@Autowired
	public JDBCTabDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.datasource = dataSource;
	}
	
	@Override
	public void pullNewTab(String userName, int flyerID) throws SQLException {
		Connection conn = datasource.getConnection();
	    Statement stmt = conn.createStatement();
		String sqlCreateTab = "INSERT INTO tab(user_name, flyer_id, isredeemed) VALUES(?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sqlCreateTab);
		pstmt.setString(0, userName);
		pstmt.setInt(1, flyerID);
		pstmt.setBoolean(2, true);
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
