package com.techelevator.model;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.UserDAO;
import com.techelevator.security.PasswordHasher;

@Component
public class JDBCUserDAO implements UserDAO {

		private JdbcTemplate jdbcTemplate;
		private PasswordHasher passwordHasher;

		@Autowired
		public JDBCUserDAO(DataSource dataSource, PasswordHasher passwordHasher) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
			this.passwordHasher = passwordHasher;
		}
		
		
		@Override
		public void createUser(User newUser) {
			byte[] salt = passwordHasher.generateRandomSalt();
			String hashedPassword = passwordHasher.computeHash(newUser.getPassword(), salt);
			String saltString = new String(Base64.encode(salt));
			Object[] params = {newUser.getFirstName(), newUser.getLastName(), hashedPassword, saltString, newUser.getUsername(), newUser.getEmail()};
			String sqlCreateNewUser = "INSERT INTO flyer_user(first_name, last_name, password, salt, user_name, email) VALUES (?,?,?,?,?,?);";
			jdbcTemplate.update(sqlCreateNewUser, params);
		}
		
		public User returnUserByUsername(String userName) {
			String sqlSearchForUser = "SELECT * "+
								      "FROM flyer_user "+
								      "WHERE (user_name) = ?;";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName);
			if(results.next()) {
				User currentUser = new User(results.getString("first_name"), results.getString("last_name"), results.getString("user_name"), results.getString("email"));
				return currentUser;
			}
			return null;
		}
		
		@Override
		public boolean searchForUsernameAndPassword(String userName, String password) {
			String sqlSearchForUser = "SELECT * "+
								      "FROM flyer_user "+
								      "WHERE UPPER(user_name) = '"+userName.toUpperCase()+"' ";
			
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser);
			if(results.next()) {
				String storedSalt = results.getString("salt");
				String storedPassword = results.getString("password");
				String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
				return storedPassword.equals(hashedPassword);
			} else {
				return false;
			}
		}

		@Override
		public void updatePassword(String userName, String password) {
			byte[] salt = passwordHasher.generateRandomSalt();
			String hashedPassword = passwordHasher.computeHash(password, salt);
			String saltString = new String(Base64.encode(salt));
			jdbcTemplate.update("UPDATE app_user SET password = '"+hashedPassword+"', salt = '"+saltString+"' WHERE user_name = '"+userName+"'");
		}
		
		@Override
		public boolean canTakeTab(String userName, int flyerID) {
			int tabsTakenByUser = 0;
			Object[] params = {userName, flyerID};
			String sqlCheckIfPulled = "SELECT COUNT(*) FROM tab WHERE user_name = ? AND flyer_id = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCheckIfPulled, params);
			while(results.next()) {
				tabsTakenByUser = results.getInt("count");
			}
			if(tabsTakenByUser > 0) {
				return false;
			}
			return true;
		}

}
