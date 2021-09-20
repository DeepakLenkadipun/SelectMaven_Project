package com.crm.autodesk.GenericLibraries;

import java.util.Random;

/**
 * This class contains generic methods pertaining to java
 * @author DEEPAK LENKA
 *
 */

public class JavaUtility {

	/**
	 * This method generates random number
	 * @return 
	 */
	public int getrandomNum() {
		
		Random ran=new Random();
		int randomNum=ran.nextInt(1000);
		return randomNum;
	}

}
