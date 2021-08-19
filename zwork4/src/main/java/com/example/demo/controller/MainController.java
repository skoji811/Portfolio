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
public class MainController {
	
	@Autowired
	UserRepository repos;
	
	@GetMapping ("/")
	public String list (Model model) {
		List <User> list = repos.findAll();
		model.addAttribute("data", list);
		return "index";
	}
	
//	@GetMapping("/edit")
//	public String edit(@RequestParam int id,Model model) {
//		User data = repos.findById(id);
//		model.addAttribute("form", data);
//		return "edit";
//		
//	}
	
	@PostMapping("/insert")
	@Transactional(readOnly = false)
	public String insert(@ModelAttribute("formInsert")User user,Model model) {
		repos.saveAndFlush(user);
		return "redirect:/";
	}
    @PostMapping("/update")
    @Transactional(readOnly=false)
    private String update(@ModelAttribute("formUpdate")User user, Model model) {
        repos.saveAndFlush(user);
        return "redirect:/";
    }
    @PostMapping("/delete")
    @Transactional(readOnly=false)
        private String delete(@ModelAttribute("formDelete")User user,Model model) {
        repos.delete(user);
        return "redirect:/";
    }
	
	
	
	
	
	
	@PostConstruct
	public void init() {
		User user1 = new User();
		user1.setName("Kevin");
		user1.setAge(10);
		repos.saveAndFlush(user1);
		
		User user2 = new User();
		user2.setName("Dian");
		user2.setAge(32);
		repos.saveAndFlush(user2);
	}
	
}
