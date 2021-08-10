package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.BulletinBoard;
import com.example.demo.repository.DemoReposiroty;

@Controller
public class DemoController {

	@Autowired DemoReposiroty DRepos;
	@GetMapping
	public String list(Model model) {
		List<BulletinBoard> list = DRepos.findAll();
		model.addAttribute("data", list);
		return "list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		BulletinBoard data = new BulletinBoard();
		model.addAttribute("formModel", data);
		return "new";
		
		
	}
	
}
