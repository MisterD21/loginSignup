package com.nandan.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nandan.springboot.model.User;
import com.nandan.springboot.repository.UserRepository;
import com.nandan.springboot.service.UserService;

@Controller
public class AppController {

	@Autowired
	UserService uservice;
	@Autowired
	UserRepository urepo;
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/signup")
	public String registerUser() {
		return "signup";
	}
	
	@RequestMapping("/login")
	public String register() {
		return "login";
	}
	
	@PostMapping("/success")
	public ModelAndView addUser(@RequestParam("user_email") String user_email, User user, Long id)
	{
		ModelAndView mv=new ModelAndView("success");
		Optional<User> findById = urepo.findById(id);
		
		if(findById.isPresent())
		{
		mv.addObject("message", "Oops!  There is already a user registered with the email provided.");
		
		}
		else
		{
		urepo.save(user);
		mv.addObject("message","User has been successfully registered.");
		}
		
		return mv;
	}
	
}
