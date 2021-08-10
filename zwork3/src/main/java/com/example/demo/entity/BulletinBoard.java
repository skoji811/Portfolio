package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bulletinBoard")
public class BulletinBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	int id;
	
	
	Date createDate;
	@Column
	String titke;
	@Column
	String comment;
	@Column
	String createUser;
	
	
}
