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
	public FlyerController(UserDAO userDAO) {
			this.userDAO = userDAO;
			this.flyerDAO = flyerDAO;
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
	}