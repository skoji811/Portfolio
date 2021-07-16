package com.example.demo.controller;

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
	
	@GetMapping("/")
	public String index(@ModelAttribute("formModel")User user,Model model) {
		Iterable<User> list = userRepository.findAll();
		model.addAttribute("data", list);
		return "index";
	}
	
	@PostMapping("/")
	@Transactional
	public String form(@ModelAttribute("formModel") User user,Model model) {
		userRepository.saveAndFlush(user);
		return "redirect:/";
	}
	
	@PostConstruct
	public void init() {
		User user1 = new User();
		user1.setName("榊原　孝司");
		userRepository.saveAndFlush(user1);
		
		User user2 = new User();
		user2.setName("田中　太郎");
		userRepository.saveAndFlush(user2);

	}
}
