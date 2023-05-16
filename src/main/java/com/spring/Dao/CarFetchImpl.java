package com.spring.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.Dao.utility.CarSelect;
import com.spring.entity.CarDetails;


public class CarFetchImpl implements CarFetch {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean insertRecord(CarDetails record) {
		String sql="INSERT INTO CARAPI VALUES(?,?,?,?)";
		Object a[]= {record.getId(),record.getColour(),record.getCostOfCar(),record.getName()};
		int update = jdbcTemplate.update(sql, a);
		return (update==1);
	}

	public boolean deleteById(int id) {
		String sql="DELETE FROM CARAPI WHERE ID=?";
		int deleteResult = jdbcTemplate.update(sql, id);
		return (deleteResult==1);
	}

	public boolean updateCost(int id, int cost) {
		String sql="UPDATE CARAPI SET COST=? WHERE ID=?";
		Object obj[]= {cost, id};
		int update = jdbcTemplate.update(sql,obj);
		return (update==1);
	}

	public List<CarDetails> ShowAllData() {
		String sql="select * from carapi";
		
		List<CarDetails> details = jdbcTemplate.query(sql, new CarSelect());
		return details;
	}

	public Map<String, List<String>> findByColour(String colour, String clr) {
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		String sql="SELECT * FROM CARAPI WHERE COLOUR=? OR COLOUR=?";
		 List<CarDetails> query = jdbcTemplate.query(sql, new CarSelect(),colour,clr);
		 List<String> colour1=new ArrayList<String>();
		 List<String> clr1=new ArrayList<String>();
		 for(CarDetails cd: query) {
			if(cd.getColour().equalsIgnoreCase(colour)) {
			colour1.add(cd.getName());
			}else if(cd.getColour().equalsIgnoreCase(clr)){
				clr1.add(cd.getName());
			}
		 }
		 map.put(colour, colour1);
		 map.put(clr, clr1);
		return map;
	}

	public Map<String, List<String>> findByGroup() {
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		String sql="select * from carapi";
		List<CarDetails> qr = jdbcTemplate.query(sql, new CarSelect());

		for(CarDetails cd: qr) {
			if(map.containsKey(cd.getColour())){
				List<String> list = map.get(cd.getColour());
				list.add(cd.getName());
				map.put(cd.getColour(), list);
			}else {
				List<String> xyz=new ArrayList<String>();
				xyz.add(cd.getName());
				map.put(cd.getColour(),xyz);
			}
		}
		return map;
	}

}
