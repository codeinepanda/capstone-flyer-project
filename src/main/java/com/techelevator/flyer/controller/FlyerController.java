package com.techelevator.flyer.controller;

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
	public FlyerController(UserDAO userDAO) {
			this.userDAO = userDAO;
	}
		
		@RequestMapping(path="/", method=RequestMethod.GET)
		public String showHomePage(Map<String, Object> model) {
	//			model.put("flyer", flyerDAO.getFeaturedFlyers());
				return "index";
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
				model.put("currentUser", currentUser);
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
		
		@RequestMapping(path="/logout", method=RequestMethod.POST)
		public String logout(Map<String, Object> model, HttpSession session) {
			model.remove("currentUser");
			return "redirect:/";
		}
	}










