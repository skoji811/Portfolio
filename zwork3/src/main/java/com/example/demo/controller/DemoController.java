package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.BulletinBoard;
import com.example.demo.repository.DemoReposiroty;

@Controller
public class DemoController {

	@Autowired DemoReposiroty dRepos;
	@GetMapping
	public String list(Model model) {
		List<BulletinBoard> list = dRepos.findAll();
		model.addAttribute("data", list);
		return "list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		BulletinBoard data = new BulletinBoard();
		model.addAttribute("bbs", data);
		return "new";
	}
	
	@GetMapping("/edit")
	public String edit (@RequestParam int id ,Model model) {
		BulletinBoard data = dRepos.findById(id);
		model.addAttribute("bbs", data);
			return "new";
	}
	
	@GetMapping("/show")
	public String show (@RequestParam int id ,Model model){
		BulletinBoard data = dRepos.findById(id);
		model.addAttribute("bbs", data);
			return "show";
	}
	
	@PostMapping("/create")
	@Transactional(readOnly = false)
	public String save(@ModelAttribute("bbs")BulletinBoard bb) {
		Date date = new Date();
		SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy/MM/dd");
		bb.setCreateDate(sdf1.format(date));
		dRepos.saveAndFlush(bb);
		return "redirect:list";
	}
	
	@PostMapping("/delete")
	@Transactional(readOnly = false)
	public String delete(@RequestParam int id) {
		dRepos.deleteById(id);
		return "redirect:list";
		
	}
	
}
