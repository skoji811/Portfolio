package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;
	
	public String home(Model model){
		List<Todo> allTodo = todoService.searchAll();
		model.addAttribute("allTodo",allTodo);
		return "home";
		}
}
	
