package org.escalade.webapp.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	public Date convert(String value) {
		if (value == "") {
			return null;
		} else {			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	        try {	
	            Date date = formatter.parse(value);
	            
	            return date;
	
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return null;
	        }
		}
	}
}
