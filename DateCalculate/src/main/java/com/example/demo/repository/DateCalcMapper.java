package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.DateCalc;

@Mapper
public interface DateCalcMapper {
	
	@Select("select * from DateCalc")
	public List <DateCalc> selectAll();
	
	@Select("select * from DateCalc where id = #{id}")
	public DateCalc selectOne(int id);
	
	@Insert("insert into DateCalc (name,prusyear,plusmonth,plusday) values (#{name},#{plusyear},#{plusmonth},#{plusday}")
	public void insertOne(DateCalc dateCalc);
	
	@Update("update DateCalc set name = #{name}, plusyear = #{plusyear}, plusmonth = #{plusmonth},plusday = #{plusday} "
			+ "where id = #{id}")
	public void updateOne(DateCalc dateCalc);
	
	@Delete("delete from DateCalc where id = #{id}")
	public void deleteOne(DateCalc dateCalc);

}
