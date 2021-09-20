package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class testAccountType {
public static void main(String []args) throws SQLException {
	    Connection con=null;
	    try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts","root","root");
		 
		Statement stat=con.createStatement();
		String query="select * from accounts";
		
		ResultSet result=stat.executeQuery(query);
		while(result.next()) {
			int acctNum=result.getInt("accountnum");
			System.out.println(acctNum);
			if(acctNum==1 &&result.getString("accounttype").equals("gold")) {
				System.out.println("account type gold & verified==pass");
				break;
			}
		}
	    }catch(Exception e) {
	    	System.err.println("account type is not gold==FAIL");
	    }finally {
		con.close();
		
	}

 }
}