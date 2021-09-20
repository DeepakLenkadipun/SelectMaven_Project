package com.crm.autodesk.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * this class contains Generic methods to read data from proprty file
 * @author DEEPAK LENKA
 *
 */
public class PropertyFileUtility {
	/**
	 * this  method reads data from propertyfile
	 * @return 
	 * @throws Throwable 
	 */
    public String getPropertyFileData(String key) throws Throwable {
    	FileInputStream fis=new FileInputStream(IPathConstants.ProprtyFilePath);
    	Properties p=new Properties();
    	p.load(fis);
    	String value=p.getProperty(key);
    	return value;
    }
}
