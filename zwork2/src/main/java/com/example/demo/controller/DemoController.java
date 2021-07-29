package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class DemoController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping()
	public String list(Model model) {
		List<User> list = userRepository.findAll();
		model.addAttribute("data",list);
		return "users/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		User data = new User();
		model.addAttribute("formModel",data);
		return "users/new";
	}
	
	@GetMapping("/edit")
		public String edit(Model model){
		User data = userRepository.findById(id);
		model.addAttribute("formModel",data);
		return "users/new";
	}
	
	@PostMapping
	@Transactional(readOnly = false)
	public String save (
			@ModelAttribute("formModel") User user){
				userRepository.saveAndFlush(user);
				return "redirect:users/list";
			}
	
	@PostConstruct
	public void unit() {
		User user1 = new User();
		user1.set
		
	}
	
	
}
