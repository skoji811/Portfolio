package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository todoRepository;

	public List<Todo> searchAll(){
		return todoRepository.findAll();
	}
	
	public void addTodo(Todo todo) {
		todoRepository.save(todo);
	}
}
