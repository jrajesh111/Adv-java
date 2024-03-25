package com.sathya.jdbc;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLex3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//creat connection
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/rajesh","root","root");
		//Using connection create statment object
		Statement statement=connection.createStatement();
		//exicute the select query & store the data in resultset
		ResultSet resultSet=statement.executeQuery("select * from emp");
		
		//to store resultset object in resultsetmetadata
		ResultSetMetaData metaData=resultSet.getMetaData();
		
		System.out.println(metaData.getColumnCount());
		System.out.println(metaData.getColumnName(2));
		System.out.println(metaData.getColumnTypeName(2));
		System.out.println(metaData.getColumnDisplaySize(2));
		
		//close the connection
		connection.close();
				
	}

}
