package com.techelevator.flyer.controller;


	package com.techelevator.flyer.controller;

	import java.util.Map;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;

	import com.techelevator.critter.model.FlyerDAO;
	import com.techelevator.critter.model.UserDAO;

@Controller
public class FlyerController {
		private userDAO userDAO;
		private flyerDAO flyerDAO;
		
	@Autowired
	public FlyerController(UserDAO userDAO, FlyerDAO messageDAO) {
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
		@RequestMapping(path="/users/register", method=RequestMethod.GET)
		public String displayNewUserForm() {
				return "register";
		}
		@RequestMapping(path="/users", method=RequestMethod.POST)
		public String createUser(@RequestParam String userName, @RequestParam String password) {
				userDAO.saveUser(userName, password);
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
				model.put("flyer", flyerDAO.getPublicMessages(10));
				return "home";
		}
	}