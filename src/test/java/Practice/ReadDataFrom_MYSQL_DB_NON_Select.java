package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFrom_MYSQL_DB_NON_Select {
public static void main(String []args) throws SQLException {
	
		//step 1 :register /load the mysql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2 :get connect to database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
		
		//step 3: create sql Statement
		Statement stat=con.createStatement();
		String query="insert into students_info (regno, firstname, middlename, lastname) values('7', 'amiet','kumar', 'patra');";
		
		//step 4: execute statement/query
		int result=stat.executeUpdate(query);
		if(result==1) {                /* +1 means successfuly created bcz it give only +ve -ve sign */
			System.out.println("user is created");
		}else {
			System.out.println("user is not created");
		}
		
		//step 5: close the connection
		con.close();
		
	}

}
