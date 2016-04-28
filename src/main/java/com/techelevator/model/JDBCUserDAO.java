package com.techelevator.model;

import java.util.HashMap;

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


		@Override
		public void createUserPreferences(String user, String company, String author, String categories) {
			String sqlCreatePreferences = "INSERT INTO prefs(user_name, company, author, category) VALUES(?,?,?,?);";
			Object[] params = {user, company, author, categories};
			jdbcTemplate.update(sqlCreatePreferences, params);
		}


		@Override
		public void updateUserPreferences(String user, String company, String author, String categories) {
			String sqlUpdatePreferences = "Update prefs " +
										  "SET company = ?, author = ?, category = ? " +
										  "WHERE user_name = ?;";
			Object[] params = {company, author, categories, user};
			jdbcTemplate.update(sqlUpdatePreferences, params);
		}


		@Override
		public boolean preferencesExist(String username) {
			String sqlHasPreferences = "SELECT COUNT(*) FROM prefs WHERE user_name = ?;";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlHasPreferences, username);
			while(results.next()) {
				if(results.getInt("count") > 0) {
					return true;
				}
			}
			return false;
		}


		@Override
		public HashMap<String, String> getUserPreferences(String username) {
			HashMap<String, String> userPrefs = new HashMap();
			String sqlGetUserPrefs = "SELECT * FROM prefs WHERE user_name = ?;";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetUserPrefs, username);
			while(results.next()) {
				userPrefs.put("company", results.getString("company"));
				userPrefs.put("author", results.getString("author"));
				userPrefs.put("categories", results.getString("category"));
			}
			return userPrefs;
		}

}
