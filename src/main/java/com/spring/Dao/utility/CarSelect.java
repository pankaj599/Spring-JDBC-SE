package com.spring.Dao.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.spring.entity.CarDetails;

public class CarSelect implements ResultSetExtractor<List<CarDetails>> {
	@Autowired
	CarDetails carDetails;
/*
 * USING Result Set Extractor
 */
	public List<CarDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CarDetails> al=new ArrayList<CarDetails>();
		while(rs.next())
		{
				CarDetails carDetails=new CarDetails();
				carDetails.setId(rs.getInt(1));
				carDetails.setColour(rs.getString(2));
				carDetails.setCostOfCar(rs.getInt(3));
				carDetails.setName(rs.getString(4));
				al.add(carDetails);
				
		}
		return al;
	}

	
	/*
	 * Using RowMapper
	 */

	/*public CarDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 CarDetails carDetails=new CarDetails();
		carDetails.setId(rs.getInt(1));
		carDetails.setColour(rs.getString(2));
		carDetails.setCostOfCar(rs.getInt(3));
		carDetails.setName(rs.getString(4));
		//carDetails.setName(null);
		return carDetails;
	}*/

	/*
	 * public List<CarDetails> extractData(ResultSet rs) throws SQLException,
	 * DataAccessException { // TODO Auto-generated method stub while(rs.next()) {
	 * carDetails.setId(rs.getInt(1)); carDetails.setColour(rs.getString(2));
	 * carDetails.setCostOfCar(rs.getInt(3)); carDetails.setName(rs.getString(4)); }
	 * return carDetails; }
	 */

}
