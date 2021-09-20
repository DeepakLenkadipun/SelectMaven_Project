package com.crm.practicechaitra;



import com.crm.autodesk.GenericLibraries.JSONFileUtility;

public class DemoFilereaderjson {
	public static void main(String[] args) throws  Throwable {
		JSONFileUtility jsonLib=new JSONFileUtility();
		
		String value=jsonLib.readDataFromJSON("username");
		
		System.out.println(value);
	}

}
