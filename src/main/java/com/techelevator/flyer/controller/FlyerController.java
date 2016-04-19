package com.techelevator.flyer.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.FlyerDAO;
import com.techelevator.model.UserDAO;

@Controller
public class FlyerController {
		private UserDAO userDAO;
		private FlyerDAO flyerDAO;
		
	@Autowired
	public FlyerController(UserDAO userDAO, FlyerDAO flyerDAO) {
			this.userDAO = userDAO;
			this.flyerDAO = flyerDAO;
		}
		@RequestMapping(path="/login", method=RequestMethod.GET)
		public String displayLoginForm() {
			return "login";
		}
		@RequestMapping(path="/login", method=RequestMethod.POST)
		public String login(Map<String, Object> model, 
								@RequestParam String userName, 
								@RequestParam String password,
								HttpSession session) {
			
				if(userDAO.searchForUsernameAndPassword(userName, password)) {
					session.invalidate();
					model.put("currentUser", userName);
					return "redirect:/users/"+userName;
				} else {
					return "redirect:/login";
				}
		}
		@RequestMapping(path="/registration", method=RequestMethod.GET)
		public String displayNewUserForm() {
				return "register";
		}
		@RequestMapping(path="/completeRegistration", method=RequestMethod.POST)
		public String createUser(@RequestParam String firstName, @RequestParam String lastName, 
								 @RequestParam String password, @RequestParam String userName,
								 @RequestParam String email) {
				userDAO.saveUser(firstName, lastName, password, userName, email);
				return "redirect:/login";
		}
		@RequestMapping(path="/logout", method=RequestMethod.POST)
		public String logout(Map<String, Object> model, HttpSession session) {
				model.remove("currentUser");
				session.removeAttribute("currentUser");
				return "redirect:/";
		}
		
		@RequestMapping(path="/", method=RequestMethod.GET)
		public String showHomePage(Map<String, Object> model) {
				model.put("flyer", flyerDAO.getAllFlyersToDisplayOnHomepage(??));
				return "home";
		}
	}