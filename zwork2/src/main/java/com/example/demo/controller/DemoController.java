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
	UserRepository repository;
	
	@GetMapping()
	public String list(Model model) {
		List<User> list = repository.findAll();
		model.addAttribute("data",list);
		return "list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		User data = new User();
		model.addAttribute("formModel",data);
		return "new";
	}
	
	@GetMapping("/edit")
		public String edit(@RequestParam int id,Model model){
		User data = repository.findById(id);
		model.addAttribute("formModel",data);
		return "new";
	}

	
	@PostMapping
	
	public String save (
			@ModelAttribute("formModel") User user){
		repository.saveAndFlush(user);
				return "redirect:/list";
			}
	
	@PostMapping("/delete")
	public String delete(@RequestParam int id) {
		repository.deleteById(id);
		return "redirect:list";
	}
	

	
	@PostConstruct
	public void unit() {
		User user1 = new User();
		user1.setName("榊原孝司");
		user1.setAddress("柏原市高井田");
		user1.setTel("123456789");
		repository.saveAndFlush(user1);
		
		User user2 = new User();
		user2.setName("榊原孝司");
		user2.setAddress("柏原市高井田");
		user2.setTel("123456789");
		repository.saveAndFlush(user2);
		
	}
	
	
}
