package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Step 1 - Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2 - Establish Connection
		Connection con = null;
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","SYSTEM@2121");
		
		if(con!=null) {
			System.out.println("Connection Established");
		}
		else {
			System.out.println("Connection not Established");
		}
		
		//STEP 3 - CREATING STATEMENT
//		PreparedStatement ps = con.prepareStatement("insert into sample.STUDENT values(?,?,?,?)");
//		ps.setInt(1, 11);
//		ps.setString(2, "test2");
//		ps.setInt(3, 45);
//		ps.setString(4, "cbe");
		
//		ps.executeUpdate();		
		PreparedStatement ps = con.prepareStatement("update sample.STUDENT set name=? where id=?");
		ps.setString(1, "name");
		ps.setInt(2, 11);		
		ps.executeUpdate();		
		//step 4 - Getting result
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from sample.STUDENT");		
		while(rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("NAME");
			int age = rs.getInt("AGE");
			String address = rs.getString("ADDRESS");			
			System.out.println("ID: "+id+" Name: "+name+" Age: "+age+" Address: "+address);
		}		
		//Step 5 - Closing the connection
		con.close();
	}
}
//SIGNUP - ID INT, FIRSTNAME VARCHAR(20), LASTNAME VARCHAR(20), AGE INT, CITY VARCHAR(20)
//INSERT 1 RECORD
//DISPLAY IT IN OUTPUT
//UPDATE THAT RECORD
//DISPLAY IT

//STATEMENT - general purpose (execute,executeUpdate, executeQuery)
//preparedStatement - input parameters (execute,executeUpdate, executeQuery)
//Callable statements - stored procedures (execute,executeUpdate, executeQuery)

//execute() -> DDL(create,alter or drop)
//executeUpdate() -> DML(insert,update,delete)
//executeQuery() -> select

