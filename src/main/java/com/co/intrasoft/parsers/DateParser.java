package com.co.intrasoft.parsers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.expression.ParseException;
/**
 * Class to convert a String to Date
 * 
 * @author Diego Imbus <dsn.imbus01@gmail.com>
 */
public class DateParser {
    
	/**
	 * Method to define the date format to convert 
	 * 
	 * @param dateF String to convert.
	 * @return Returns a date to work with
	 */
	public Date parseDate (String dateF) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		try {
			date = format.parse(dateF);
		} 
		catch (ParseException | java.text.ParseException e) 
		{
			e.printStackTrace();
		}
		
		return date;
	}
	
}
