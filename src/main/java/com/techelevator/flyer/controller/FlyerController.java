package com.techelevator.flyer.controller;

import java.sql.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("currentUser")
@Transactional
public class FlyerController {
		private UserDAO userDAO;
		private FlyerDAO flyerDAO;
		
	@Autowired
	public FlyerController(UserDAO userDAO, FlyerDAO flyerDAO) {
			this.userDAO = userDAO;
			this.flyerDAO = flyerDAO;
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
				return "dashboard";
			} else {
				model.put("column1", column1);
				model.put("column2", column2);
				model.put("notPreview", notPreview);
				return "index";
			}
		}
		
		@RequestMapping(path="/previewSelected", method=RequestMethod.GET)
		public String previewSelectedFlyer(Map<String, Object> model, @RequestParam("flyerName") String flyerName,
																   @RequestParam("userName") String userName,
																   @RequestParam("company") String company,
																   @RequestParam("startDate") String start,
																   @RequestParam("endDate") String end,
																  // @RequestParam("createDate") String create,
																   @RequestParam("numTabs") int numTabs,
																   @RequestParam("category") String category,
																   @RequestParam("flyerInfo") String flyerDescription) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate startDate = LocalDate.parse(start, formatter);
			LocalDate endDate = LocalDate.parse(end, formatter);
		//	LocalDate createDate = LocalDate.parse(create, formatter);
			System.out.println("Inside show selected");
			Flyer selectedFlyer = new Flyer(userName, company, flyerName, startDate, endDate, numTabs, category, flyerDescription);
	//		selectedFlyer.setCreateDate(createDate);
			System.out.println("Created selectedFlyer object");
			model.put("selectedFlyer", selectedFlyer);
			System.out.println("Put selectedFlyer into model.");
			return "selectedFlyer";
		}
		
		@RequestMapping(path="/viewSelected", method=RequestMethod.GET)
		public String openSelectedFlyer(Map<String, Object> model, @RequestParam("flyerName") String flyerName,
																   @RequestParam("userName") String userName,
																   @RequestParam("company") String company,
																   @RequestParam("startDate") String start,
																   @RequestParam("endDate") String end,
																  // @RequestParam("createDate") String create,
																   @RequestParam("numTabs") int numTabs,
																   @RequestParam("category") String category,
																   @RequestParam("flyerInfo") String flyerDescription) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate startDate = LocalDate.parse(start, formatter);
			LocalDate endDate = LocalDate.parse(end, formatter);
		//	LocalDate createDate = LocalDate.parse(create, formatter);
			System.out.println("Inside show selected");
			Flyer selectedFlyer = new Flyer(userName, company, flyerName, startDate, endDate, numTabs, category, flyerDescription);
	//		selectedFlyer.setCreateDate(createDate);
			System.out.println("Created selectedFlyer object");
			model.put("selectedFlyer", selectedFlyer);
			model.put("notPreview", true);
			System.out.println("Put selectedFlyer into model.");
			return "selectedFlyer";
		}
		
		@RequestMapping(path="/registration", method=RequestMethod.GET)
		public String showRegistrationPage() {
			return "register";
		}
		
		@RequestMapping(path="/createUser", method=RequestMethod.POST)
		public String showRegistrationConfirmation(@RequestParam("firstName") String first,
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
			//	List<Flyer> userFlyers = flyerDAO.getAllFlyersForUser(display);
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
		public String showNewFlyerConfirmation(Map<String, Object> model, @RequestParam("flyerName") String flyer,
																		  @RequestParam("companyName") String company,
																		  @RequestParam("startDate") Date start,
																		  @RequestParam("expDate") Date expire,
																		  @RequestParam("numTabs") int tabs,
																		  @RequestParam("category") String cat,
																		  @RequestParam("description") String info,
																		  HttpSession session) {
			LocalDate startDate = start.toLocalDate();
			LocalDate endDate = expire.toLocalDate();
			LocalDate createDate = LocalDate.now();
			User currentUser = (User) session.getAttribute("currentUser");
			Flyer newFlyer = new Flyer(currentUser.getUsername(), company, flyer, startDate, endDate, tabs, cat, info);
			newFlyer.setCreateDate(createDate);
			session.putValue("newFlyer", newFlyer);
			return "newFlyerComplete";
		}
		
		@RequestMapping(path="/viewYourFlyer", method=RequestMethod.GET)
		public String previewNewFlyer(Map<String, Object> model, HttpSession session) {
			User currentUser = (User) session.getAttribute("currentUser");
			Flyer newFlyer = (Flyer) session.getAttribute("newFlyer");
			int days = (int) ChronoUnit.DAYS.between(newFlyer.getStartDate(), newFlyer.getEndDate());
			if(currentUser.getUsername().equals(newFlyer.getUserName())) {
				System.out.println("Usernames match");
				model.put("newFlyer", newFlyer);
				model.put("days", days);
				return "newFlyer";
			} else {
				return "permissionsError";
			}
		}
		
		@RequestMapping(path="/confirmPublish", method=RequestMethod.GET)
		public String displayPublicationConfirmation(Map<String, Object> model, HttpSession session) {
			User currentUser = (User) session.getAttribute("currentUser");
			Flyer newFlyer = (Flyer) session.getAttribute("newFlyer");
			if(currentUser.getUsername().equals(newFlyer.getUserName())) {
				System.out.println("Usernames match");
				flyerDAO.createFlyer(newFlyer);
				return "publishComplete";
			} else {
				return "permissionsError";
			}
		}
		
		@RequestMapping(path="/cancelPublish", method=RequestMethod.GET)
		public String returnHomeAfterCancellation(Map<String, Object> model, HttpSession session) {
			User currentUser = (User) session.getAttribute("currentUser");
			Flyer newFlyer = (Flyer) session.getAttribute("newFlyer");
			if(currentUser.getUsername().equals(newFlyer.getUserName())) {
				System.out.println("Usernames match");
				session.removeAttribute("newFlyer");
				model.remove("newFlyer");
				return "redirect:/";
			} else {
				return "permissionsError";
			}
		}
		
		@RequestMapping(path="/logout", method=RequestMethod.POST)
		public String logout(Map<String, Object> model, HttpSession session) {
			model.remove("currentUser");
			session.removeAttribute("currentUser");
			return "redirect:/";
		}
		
		
		
	}










