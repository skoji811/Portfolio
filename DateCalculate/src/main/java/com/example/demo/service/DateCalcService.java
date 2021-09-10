package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DateCalc;
import com.example.demo.repository.DateCalcMapper;

@Service
public class DateCalcService {

	@Autowired
	DateCalcMapper mapper;
	
	public List<DateCalc> selectAll(){
		return mapper.selectAll();
		
	}
	
	public DateCalc selectOne (int id) {
		return mapper.selectOne(id);
	}
	
	public void insertOne(DateCalc dateCalc) {
		mapper.insertOne(dateCalc);
	}
	
	public void updateOne(DateCalc dateCalc) {
		mapper.updateOne(dateCalc);
	}
	
	public void deleteOne(DateCalc dateCalc) {
		mapper.deleteOne(dateCalc);
	}
}
