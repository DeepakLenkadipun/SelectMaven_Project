package com.crm.practicechaitra;


import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXml {
	@Test
	public void readDataFromXml(XmlTest xmlobj) {
		System.out.println(xmlobj.getParameter("browser"));
		System.out.println(xmlobj.getParameter("url"));
		System.out.println(xmlobj.getParameter("username"));
		System.out.println(xmlobj.getParameter("password"));
		
	}

}
