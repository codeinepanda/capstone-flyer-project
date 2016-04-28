package com.techelevator.flyer.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.Flyer;
import com.techelevator.model.FlyerDAO;
import com.techelevator.model.Tab;
import com.techelevator.model.TabDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes({"currentUser", "userPreferences"})
@Transactional
public class FlyerController {
		private UserDAO userDAO;
		private FlyerDAO flyerDAO;
		private TabDAO tabDAO;
		
	@Autowired
	public FlyerController(UserDAO userDAO, FlyerDAO flyerDAO, TabDAO tabDAO) {
			this.userDAO = userDAO;
			this.flyerDAO = flyerDAO;
			this.tabDAO = tabDAO;
	}
		
		@RequestMapping(path="/", method=RequestMethod.GET)
		public String showHomePage(Map<String, Object> model, HttpSession session) {
			boolean notPreview = false;
			ArrayList<Flyer> featuredFlyers = flyerDAO.getFeaturedFlyers();
			ArrayList<Flyer> column1 = new ArrayList();
			ArrayList<Flyer> column2 = new ArrayList();
			for(int i = 0; i < featuredFlyers.size(); i++) {
				if(i < featuredFlyers.size()/2) {
					column1.add(featuredFlyers.get(i));
				} else {
					column2.add(featuredFlyers.get(i));
				}
			}
			if(session.getAttribute("currentUser") != null) {
				model.put("column1", column1);
				model.put("column2", column2);
				return "dashboard";
			} else {
				model.put("column1", column1);
				model.put("column2", column2);
				model.put("notPreview", notPreview);
				return "index";
			}
		}
		
		@RequestMapping(path="/previewSelected", method=RequestMethod.GET)
		public String previewSelectedFlyer(Map<String, Object> model, HttpSession session, @RequestParam("flyerName") String flyerName,
																   						   @RequestParam("userName") String userName,
																   						   @RequestParam("company") String company,
																   						   @RequestParam("flyerID") int flyerID,
																   						   @RequestParam("startDate") String start,
																   						   @RequestParam("endDate") String end,
																   						   @RequestParam("createDate") String create,
																   						   @RequestParam("numTabs") int numTabs,
																   						   @RequestParam("category") String category,
																   						   @RequestParam("flyerInfo") String flyerDescription,
																   						   @RequestParam("isRetired") boolean isRetired) {
			User currentUser = null;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate startDate = LocalDate.parse(start, formatter);
			LocalDate endDate = LocalDate.parse(end, formatter);
			LocalDate createDate = LocalDate.parse(create, formatter);
			System.out.println("Inside show selected");
			String[] categories = category.split(Pattern.quote(","));
			Flyer selectedFlyer = new Flyer(userName, company, flyerName, startDate, endDate, numTabs, flyerDescription, isRetired);
			for(String cat : categories) {
				selectedFlyer.getCategories().add(cat);
			}
			selectedFlyer.setCreateDate(createDate);
			selectedFlyer.setFlyerID(flyerID);
			System.out.println("Created selectedFlyer object");
			
			if(session.getAttribute("currentUser") != null) {
				currentUser = (User) session.getAttribute("currentUser");
				if(currentUser.getUsername().equals(selectedFlyer.getUserName())) {
					model.put("author", currentUser.getUsername());
				}
			}
			model.put("selectedFlyer", selectedFlyer);
			System.out.println("Put selectedFlyer into model.");
			return "selectedFlyer";
		}
		
		@RequestMapping(path="/searchFlyers", method=RequestMethod.GET)
		public String showFilterForm() {
			return "filterForm";
		}
		
		@RequestMapping(path="/filterFlyers", method=RequestMethod.POST)
		public String showFilteredFlyers(Map<String, Object> model, HttpSession session, @RequestParam("company") String company,
																						 @RequestParam("flyerName") String flyerName,
																						 @RequestParam("userName") String userName,
																						 @RequestParam("category") String category,
																						 @RequestParam("orderBy") String orderBy) {
			if(session.getAttribute("currentUser") != null) {
				User currentUser = (User) session.getAttribute("currentUser");
				model.put("currentUser", currentUser);
			}
			String order = "";
			if(orderBy.equals("popularity")) {
				order = "(SELECT COUNT(*) FROM tab WHERE tab.flyer_id = flyer.flyer_id)";
			} else if(orderBy.equals("endDate")) {
				order = "end_date";
			} else if(orderBy.equals("numTabs")) {
				order = "num_tabs";
			} else if(orderBy.equals("createDate")) {
				order = "create_date";
			}
			System.out.println("The categories field is populated with: " + category);
			ArrayList<Flyer> filteredFlyers = flyerDAO.getFlyersFiltered(userName.toUpperCase(), category, flyerName.toUpperCase(), company.toUpperCase(), order);
			ArrayList<Flyer> column1 = new ArrayList();
			ArrayList<Flyer> column2 = new ArrayList();
			
			model.put("filteredFlyers", filteredFlyers);
			
			return "filteredFlyers";
		}
		
		@RequestMapping(path="/preferences", method=RequestMethod.GET)
		public String showPreferencesForm(Map<String, Object> model) {
			ArrayList<String> categories = flyerDAO.getAllUniqueValuesFromCategory();
			ArrayList<String> companies = new ArrayList();
			ArrayList<String> authors = new ArrayList();
			companies = flyerDAO.getAllUniqueValuesFromFlyer("company");
			authors = flyerDAO.getAllUniqueValuesFromFlyer("user_name");
			model.put("categories", categories);
			model.put("companies", companies);
			model.put("authors", authors);
			return "userPreferences";
		}
		
		@RequestMapping(path="/createPreferences", method=RequestMethod.POST)
			public String generateUserPreferences(Map<String, Object> model, HttpSession session, @RequestParam("author") String author,
																	   @RequestParam("categories") String category,
																	   @RequestParam("company") String company) {
				String message = "Great! Your preferences have been recorded. Whenever any new flyers are created " +
								 "which match your preferences, you can view them by selecting \"Recommended Flyers\" in " +
								 "your navigation bar.";
				model.put("message", message);
				HashMap userPreferences = new HashMap();
				userPreferences.put("author", author);
				userPreferences.put("categories", category);
				userPreferences.put("company", company);
				session.setAttribute("userPreferences", userPreferences);
				return "userPreferencesComplete";
			}
		
		@RequestMapping(path="/recommendedFlyers", method=RequestMethod.GET)
			public String showRecommendedFlyers(Map<String, Object> model, HttpSession session) {
				User currentUser;
				ArrayList<Flyer> recommendedFlyers;
				if(session.getAttribute("currentUser") != null) {
					currentUser = (User) session.getAttribute("currentUser");
					if(session.getAttribute("userPreferences") != null) {
						HashMap<String, String> userPreferences = (HashMap<String, String>) session.getAttribute("userPreferences");
						recommendedFlyers = flyerDAO.getFlyersFiltered(userPreferences.get("author"), userPreferences.get("categories"), "", userPreferences.get("company"), "create_date");
						model.put("filteredFlyers", recommendedFlyers);
						return "filteredFlyers";
					} else {
						return "featured";
					}
				} else {
					String message = "Sorry, you need need to be a registered member to get personalized recommendations";
					return "permissionsError";
				}
			}
		
		@RequestMapping(path="/viewSelected", method=RequestMethod.GET)
		public String openSelectedFlyer(Map<String, Object> model, @RequestParam("flyerName") String flyerName,
																   @RequestParam("userName") String userName,
																   @RequestParam("company") String company,
																   @RequestParam("flyerID") int flyerID,
																   @RequestParam("startDate") String start,
																   @RequestParam("endDate") String end,
																   @RequestParam("createDate") String create,
																   @RequestParam("numTabs") int numTabs,
																   @RequestParam("category") String category,
																   @RequestParam("flyerInfo") String flyerDescription,
																   @RequestParam("isRetired") boolean isRetired) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate startDate = LocalDate.parse(start, formatter);
			LocalDate endDate = LocalDate.parse(end, formatter);
			LocalDate createDate = LocalDate.parse(create, formatter);
			System.out.println("Inside show selected");
			String[] categories = category.split(Pattern.quote(","));
			Flyer selectedFlyer = new Flyer(userName, company, flyerName, startDate, endDate, numTabs, flyerDescription, isRetired);
			for(String cat : categories) {
				selectedFlyer.getCategories().add(cat);
			}
			selectedFlyer.setCreateDate(createDate);
			selectedFlyer.setFlyerID(flyerID);
			System.out.println("Created selectedFlyer object");
			model.put("selectedFlyer", selectedFlyer);
			model.put("notPreview", true);
			System.out.println("Put selectedFlyer into model.");
			return "selectedFlyer";
		}
		
		@RequestMapping(path="/retireFlyer", method=RequestMethod.GET)
		public String showRetireFlyerComplete(Map<String, Object> model, @RequestParam("flyerID") int flyerID) {
			flyerDAO.retireAFlyer(flyerID);
			tabDAO.redeemAllTabsByFlyer(flyerID);
			return "retireFlyerComplete";
		}
		
		@RequestMapping(path="/pullTab", method=RequestMethod.GET)
		public String showFlyerMinusTab(Map<String, Object> model, HttpSession session, @RequestParam("flyerName") String flyerName,
				   																		@RequestParam("userName") String userName,
				   																		@RequestParam("company") String company,
				   																		@RequestParam("flyerID") int flyerID,
				   																		@RequestParam("startDate") String start,
				   																		@RequestParam("endDate") String end,
				   																		@RequestParam("createDate") String create,
				   																		@RequestParam("numTabs") int numTabs,
				   																		@RequestParam("category") String category,
				   																		@RequestParam("flyerInfo") String flyerDescription,
				   																		@RequestParam("isRetired") boolean isRetired) {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate startDate = LocalDate.parse(start, formatter);
			LocalDate endDate = LocalDate.parse(end, formatter);
			LocalDate createDate = LocalDate.parse(create, formatter);
			String[] categories = category.split(Pattern.quote(","));
			Flyer selectedFlyer = new Flyer(userName, company, flyerName, startDate, endDate, numTabs, flyerDescription, isRetired);
			for(String cat : categories) {
				selectedFlyer.getCategories().add(cat);
			}
			selectedFlyer.setCreateDate(createDate);
			selectedFlyer.setFlyerID(flyerID);
			model.put("selectedFlyer", selectedFlyer);
			String message = "";
			if(session.getAttribute("currentUser") != null) {
				User currentUser = (User) session.getAttribute("currentUser");
				if(userDAO.canTakeTab(currentUser.getUsername(), flyerID)) {
					System.out.println("Unredeemed tabs: " + tabDAO.getNumUnredeemedTabsFromUser(currentUser.getUsername()));
					System.out.println("Allowable tabs: " + tabDAO.getNumAllowableTabs(currentUser.getUsername()));
					if(tabDAO.getNumUnredeemedTabsFromUser(currentUser.getUsername()) < tabDAO.getNumAllowableTabs(currentUser.getUsername())) {
						message = flyerDAO.pullTab(flyerID);
						tabDAO.generateNewTab(currentUser.getUsername(), flyerID);
						System.out.println("Unredeemed tabs: " + tabDAO.getNumUnredeemedTabsFromUser(currentUser.getUsername()));
						System.out.println("Allowable tabs: " + tabDAO.getNumAllowableTabs(currentUser.getUsername()));
					model.put("message", message);
					} else {
						message = "Sorry, but it looks like you've already taken your maximum allowable number of tabs. You can " +
								  "increase your maximum allowable tabs by redeeming some of the tabs you're currently holding onto.";
						model.put("message", message);
						return "permissionsError";
					}
				} else {
					message = "Sorry, no more than one tab per flyer! If you like this offer, be sure to have a look at similar flyers!";
					model.put("message", message);
					return "permissionsError";
				}
				return "selectedFlyer";
			}
			message = "Sorry, it looks like you don't have permission to take tabs. Only registered members can do that. " +
					  "If you are a registered member, make sure you're logged in. Otherwise, " +
					  "click on \"Register\" in the upper-right corner of the screen to " +
					  "taking advantage of all the great promotions and deals our flyers offer!";
			model.put("message", message);
			return "permissionsError";
		}
		
		@RequestMapping(path="/viewTabs", method=RequestMethod.GET)
		public String showUserTabs(Map<String, Object> model, HttpSession session) {
			String message = "";
			int redemptionPoints = 0;
			if(session.getAttribute("currentUser") != null) {
				User currentUser = (User) session.getAttribute("currentUser");
				ArrayList<Tab> unredeemedTabs = tabDAO.getTabsByHolder(currentUser.getUsername());
				model.put("tabs", unredeemedTabs);
				redemptionPoints = tabDAO.getNumAllowableTabs(currentUser.getUsername());
				model.put("points", redemptionPoints);
				return "tabs";
			} else {
				message = "Sorry, it appears you don't have permission to view that resource. Please ensure that you're logged in " +
						  "and try again.";
				model.put("message", message);
				return "permissionsError";
			}
		}
		
		@RequestMapping(path="/redeemTab", method=RequestMethod.GET)
		public String showRedemptionSuccess(Map<String, Object> model, HttpSession session, @RequestParam("flyerID") int flyerID) {
			User currentUser = (User) session.getAttribute("currentUser");
			tabDAO.redeemTab(currentUser.getUsername(), flyerID);
			System.out.println("Current User is: " + currentUser.getUsername());
			System.out.println("Flyer ID is: " + flyerID);
			return "redemptionComplete";
		}
		
		@RequestMapping(path="/registration", method=RequestMethod.GET)
		public String showRegistrationPage() {
			return "register";
		}
		
		@RequestMapping(path="/createUser", method=RequestMethod.POST)
		public String showRegistrationConfirmation(Map<String, Object> model, @RequestParam("firstName") String first,
												   							  @RequestParam("lastName") String last,
												   							  @RequestParam("username") String display,
												   							  @RequestParam("email") String Email,
												   							  @RequestParam("password") String pwd) {
			
			User newUser = new User(first, last, display, Email, pwd);
			userDAO.createUser(newUser);
			return "registrationComplete";
		}
		
		@RequestMapping(path="/loginPage", method=RequestMethod.GET)
		public String showLoginPage() {
			return "login";
		}
		
		@RequestMapping(path="/login", method=RequestMethod.POST)
		public String showDashboard(Map<String, Object> model, @RequestParam("username") String display,
															   @RequestParam("password") String pwd,
															   HttpSession session) {
			System.out.println("Login controller reached");
			if(userDAO.searchForUsernameAndPassword(display, pwd)) {
				session.invalidate();
				System.out.println("User Found");
				User currentUser = userDAO.returnUserByUsername(display);
				ArrayList<Flyer> featuredFlyers = flyerDAO.getFeaturedFlyers();
				ArrayList<Flyer> column1 = new ArrayList();
				ArrayList<Flyer> column2 = new ArrayList();
				for(int i = 0; i < featuredFlyers.size(); i++) {
					if(i < featuredFlyers.size()/2) {
						column1.add(featuredFlyers.get(i));
					} else {
						column2.add(featuredFlyers.get(i));
					}
				}
				model.put("currentUser", currentUser);
				model.put("column1", column1);
				model.put("column2", column2);
				return "dashboard";
			}
			System.out.println("User NOT Found!");
			String error = "Sorry, but we didn't find any accounts that match your login details. Please ensure that the username and password you entered were correct and try again.";
			model.put("error", error);
			return "login";
		}
		
		@RequestMapping(path="/flyerForm", method=RequestMethod.GET)
		public String showFlyerForm(Map<String, Object> model, HttpSession session) {
			if(session.getAttribute("currentUser") != null) {
				model.put("currentUser", session.getAttribute("currentUser"));
				return "createFlyer";
			} else {
				return "redirect:/login";
			}
		}
		
		@RequestMapping(path="/createFlyer", method=RequestMethod.POST)
		public String showNewFlyerConfirmation(Map<String, Object> model, HttpSession session,
																		  @RequestParam("flyerName") String flyer,
																		  @RequestParam("companyName") String company,
																		  @RequestParam("startDate") Date start,
																		  @RequestParam("expDate") Date expire,
																		  @RequestParam("numTabs") int tabs,
																		  @RequestParam("category") String cat,
																		  @RequestParam("description") String info) {
			LocalDate startDate = start.toLocalDate();
			LocalDate endDate = expire.toLocalDate();
			LocalDate createDate = LocalDate.now();
			User currentUser = (User) session.getAttribute("currentUser");
			String[] categories = cat.split(Pattern.quote(","));
			Flyer newFlyer = new Flyer(currentUser.getUsername(), company, flyer, startDate, endDate, tabs, info, false);
			for(String category : categories) {
				newFlyer.getCategories().add(category);
			}
			newFlyer.setCreateDate(createDate);
			session.putValue("newFlyer", newFlyer);
			return "newFlyerComplete";
		}
		
		@RequestMapping(path="/viewYourFlyer", method=RequestMethod.GET)
		public String previewNewFlyer(Map<String, Object> model, HttpSession session) {
			String message = "Sorry, something went wrong with your request! It looks like you don't have permission to view the requested resource!";
			User currentUser = (User) session.getAttribute("currentUser");
			Flyer newFlyer = (Flyer) session.getAttribute("newFlyer");
			int days = (int) ChronoUnit.DAYS.between(newFlyer.getStartDate(), newFlyer.getEndDate());
			if(currentUser.getUsername().equals(newFlyer.getUserName())) {
				System.out.println("Usernames match");
				model.put("newFlyer", newFlyer);
				model.put("days", days);
				return "newFlyer";
			} else {
				model.put("message", message);
				return "permissionsError";
			}
		}
		
		@RequestMapping(path="/confirmPublish", method=RequestMethod.GET)
		public String displayPublicationConfirmation(Map<String, Object> model, HttpSession session) {
			String message = "Sorry, but you don't have permission to take that action. Ensure that you are logged in and try again!";
			User currentUser = (User) session.getAttribute("currentUser");
			Flyer newFlyer = (Flyer) session.getAttribute("newFlyer");
			if(currentUser.getUsername().equals(newFlyer.getUserName())) {
				System.out.println("Usernames match");
				flyerDAO.createFlyer(newFlyer);
				return "publishComplete";
			} else {
				model.put("message", message);
				return "permissionsError";
			}
		}
		
		@RequestMapping(path="/cancelPublish", method=RequestMethod.GET)
		public String returnHomeAfterCancellation(Map<String, Object> model, HttpSession session) {
			String message = "Sorry, something went wrong with your request! It looks like you don't have permission to view the requested resource!";
			User currentUser = (User) session.getAttribute("currentUser");
			Flyer newFlyer = (Flyer) session.getAttribute("newFlyer");
			if(currentUser.getUsername().equals(newFlyer.getUserName())) {
				System.out.println("Usernames match");
				session.removeAttribute("newFlyer");
				model.remove("newFlyer");
				return "redirect:/";
			} else {
				model.put("message", message);
				return "permissionsError";
			}
		}
		
		@RequestMapping(path="/logout", method=RequestMethod.GET)
		public String logout(Map<String, Object> model, HttpSession session) {
			model.remove("currentUser");
			session.removeAttribute("currentUser");
			return "redirect:/";
		}
		
		
	}










