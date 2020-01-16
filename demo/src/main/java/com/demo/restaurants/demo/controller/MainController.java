package com.demo.restaurants.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.restaurants.demo.formbean.UserForm;
import com.demo.restaurants.demo.model.Restaurant;
import com.demo.restaurants.demo.model.User;
import com.demo.restaurants.demo.repository.RestaurantRepository;
import com.demo.restaurants.demo.repository.UserRepository;
import com.demo.restaurants.demo.utils.ManhattenDistanceSimilarityExample;
import com.demo.restaurants.demo.utils.RestaurantParser;

@Controller
public class MainController {

	@Autowired
	private RestaurantRepository restaurantRepository; 
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private ManhattenDistanceSimilarityExample manhattenDistanceSimilarityExample; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHome(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();  
		session.invalidate();  
		
		manhattenDistanceSimilarityExample.runPrediciton();

		return "home";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String viewUser(Model model, HttpServletRequest request, HttpSession session) {
		UserForm userForm = (UserForm) session.getAttribute("user");
		User user = userRepository.findByUserName(userForm.getUserName());
		model.addAttribute("user",user);
		
		return "userProfile";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin(Model model, HttpServletRequest request) {
		model.addAttribute("user", new UserForm());
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String viewLoginValue(Model model, HttpServletRequest request, @ModelAttribute("user") UserForm user, 
			final RedirectAttributes redirectAttributes, HttpSession session) {
		session.setAttribute("user", user);
		
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String viewSignUp(Model model, HttpServletRequest request) {

		return "signUp";
	}
	
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String viewTop10Res(Model model, HttpServletRequest request) {
		List<Restaurant> listRestaurant = restaurantRepository.findAll();
		System.out.println(listRestaurant.size());
		model.addAttribute("timelineList", listRestaurant.subList(0, 5));
		
		listRestaurant.sort(Comparator.comparingDouble(Restaurant::getRating).reversed());
		
		List<Restaurant> listRestaurantWithOver1kReviews = listRestaurant
				  .stream()
				  .filter(c -> c.getNumberReviews() >= 1000)
				  .collect(Collectors.toList());
		model.addAttribute("timelineList", listRestaurantWithOver1kReviews.subList(0, 10));
		
		return "top10rest";
	}
	
	@RequestMapping(value = "/timeline", method = RequestMethod.GET)
	public String viewTimeline(Model model, HttpServletRequest request) {
		List<Restaurant> listRestaurant = restaurantRepository.findAll();
		model.addAttribute("timelineList", listRestaurant.subList(0, 2));
		return "timeline";
	}

}
