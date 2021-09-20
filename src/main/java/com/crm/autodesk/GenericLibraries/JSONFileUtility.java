package com.crm.autodesk.GenericLibraries;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author DEEPAK LENKA
 *
 */

public class JSONFileUtility {
	/**
	 * this method reads the file from jason file
	 * @throws Throwable 
	 *  
	 */

	public String readDataFromJSON(String key) throws Throwable {
		
		//read the dat from json file
		FileReader file=new FileReader(IPathConstants.JSONFilePath);
		
		//convert json file into java object
	
		JSONParser jsonobj=new JSONParser();
		Object jobj=jsonobj.parse(file);
		
		//type cast java obj to hashmap
		HashMap map=(HashMap)jobj;
		String value=map.get(key).toString();
		
		//return the value
		return value;
	}
}
