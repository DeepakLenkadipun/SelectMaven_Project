package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataForm_MYSQL_DB {
	public static void main(String []args) throws SQLException {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students","root","root");
		Statement stat=con.createStatement();
		String query="select * from students_info";
		ResultSet result=stat.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		con.close();
		
	}

}
