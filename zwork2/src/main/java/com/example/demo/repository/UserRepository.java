package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	public 	User findById(int id);
	public void deleteById(int id);

}
