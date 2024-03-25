package project1.product.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Productconnect {

	public static Connection proConn() 
	{
		
		Connection connection=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","rajesh","rajesh");
		}
		catch (ClassNotFoundException |SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}

}
