package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
@GetMapping("/")
public String index(Model model) {
	model.addAttribute("msg", "名前を入力して下さい");
	return "index";
}
	
}
