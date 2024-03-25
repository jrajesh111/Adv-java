package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlConn {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/rajesh","root","root");
		System.out.println("connection created mysql database");
		//creat preparedstatment object connection execute the query
		
		PreparedStatement preparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");
			//set the input preparestatement
		preparedStatement.setInt(1,111);
		preparedStatement.setString(2, "rajesh");
		preparedStatement.setFloat(3, 15000.0f);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1,112);
		preparedStatement.setString(2, "jittu");
		preparedStatement.setFloat(3, 16000.0f);
		preparedStatement.addBatch();
		
		preparedStatement.setInt(1,113);
		preparedStatement.setString(2, "mahesh");
		preparedStatement.setFloat(3, 18000.0f);
		preparedStatement.addBatch();
		
		preparedStatement.executeBatch();
		connection.close();
		
	}

}
