package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		public String edit(@RequestParam int id,Model model){
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
	
	@PostMapping("/delete")
	@Transactional(readOnly = false)
	public String delete(@RequestParam int id) {
		userRepository.deleteById(id);
		return "redirect:users/list";
	}
	
	@PostConstruct
	public void unit() {
		User user1 = new User();
		user1.setName("榊原孝司");
		user1.setAddress("柏原市高井田");
		user1.setTel("08061644280");
		userRepository.saveAndFlush(user1);
		
	}
	
	
}
