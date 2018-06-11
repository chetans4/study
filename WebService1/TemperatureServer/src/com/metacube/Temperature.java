package com.metacube;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Class name-TemperatureConverter
 * 
 * @version 1.0
 * @author Jaya Bapna
 */

/* A class to return temperature in degree celsius.
 */

@WebService
public class Temperature {
	
	@WebMethod
	/**
	 * Below function takes input as temperature in degree fahrenheit and returns temperature in celsius
	 * after conversion.
	 * @param fahrenheit
	 * @return temperature in celsius
	 */
	public double tempConverter(double fahrenheit){
		double celsius = ((fahrenheit - 32) * 5) / 9;
		return celsius;										//returns temperature in degree celsius
	}
}
