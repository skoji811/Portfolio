package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BulletinBoard;

public interface DemoReposiroty extends JpaRepository<BulletinBoard , Long >{

	public BulletinBoard findById(int id);
	public void deleteById(int id);
	
}
