package com.spring.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Dao.CarFetch;
import com.spring.Dao.CarFetchImpl;
import com.spring.entity.CarDetails;

public class App 
{


    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("jdbcConfig.xml");
    	CarFetch carfetch = context.getBean("carfetch",CarFetchImpl.class);
    	//CarDetails cod= new CarDetails(8, "black",165,"AUDI");
    /*	if(carfetch.deleteById(9));
    	{
    		System.out.println("Deletion Success");
    		if(carfetch.insertRecord(cod)) {
    			System.out.println("Insertion Successful");
    			if(carfetch.updateCost(8, 908464)) {
    				System.out.println("Update successful");
    				List<CarDetails> showAllData = carfetch.ShowAllData();
    		    	for(CarDetails cd: showAllData)
    		    	{
    		    		System.out.println(cd);
    		    	}
    			}
    		}
    	}
    	*/
    	
    	//System.out.println(carfetch.insertRecord(cd));
    	//Map<String, List<String>> findByColour = carfetch.findByColour("blue", "black");
    	Map<String, List<String>> findByGroup = carfetch.findByGroup();
    	System.out.println(findByGroup);
    	context.close();
    }
}
