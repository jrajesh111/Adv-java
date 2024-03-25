package jdbcproject;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcconnetion12 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//step-1 load driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("connection created ");
		
		//step-2 creat connection 
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rajesh","rajesh");
		
		//System.out.println("connection created success");
		//step-3 static query exicution
		java.sql.Statement statement=connection.createStatement();
		
		String q1="create table emp(id number,name varchar2(30),salary number)";
		int res1=statement.executeUpdate(q1);
		System.out.println("table created successfully...."+res1);

		String q2="drop table emp";
		int res2=statement.executeUpdate(q2);
		System.out.println("table dropped successfully....."+res2);
		
		//step-4 close the connection
		connection.close();
		System.out.println("connection closed");
	}

}
