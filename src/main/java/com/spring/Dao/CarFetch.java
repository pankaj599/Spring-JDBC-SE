package com.spring.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.entity.CarDetails;

@Repository
public interface CarFetch {
	boolean insertRecord(CarDetails carDetails);
	boolean deleteById(int id);
	boolean updateCost(int id, int cost);
	List<CarDetails> ShowAllData();
	Map<String,List<String>>findByColour(String colour, String clr);
	Map<String,List<String>>findByGroup();
}
