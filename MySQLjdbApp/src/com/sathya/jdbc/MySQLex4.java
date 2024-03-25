package com.sathya.jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

											//database metadata
public class MySQLex4 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
					//load driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//creat connection
				
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/rajesh","root","root");
				//create databasemeta data object 
				DatabaseMetaData metaData=connection.getMetaData();
				
				System.out.println(metaData.getDatabaseProductName());
				System.out.println(metaData.getDatabaseProductVersion());
				System.out.println(metaData.getDriverName());
				System.out.println(metaData.getUserName());
				System.out.println(metaData.getURL());
				
				connection.close();

	}
}
