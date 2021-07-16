package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
public String index(Model model) {
	model.addAttribute("msg", "名前を入力して下さい");
	return "index";
}
	@PostMapping("/")
	public String send(@RequestParam("text1") String str,Model model) {
		model.addAttribute("msg","Hello  " + str + "  !!");
		return "index";
		
	}
}
