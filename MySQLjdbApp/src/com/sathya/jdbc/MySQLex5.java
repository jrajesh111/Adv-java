package com.sathya.jdbc;     
import java.sql.Connection;    
import java.sql.DriverManager;     
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
		//Rowset is used to store the data
public class MySQLex5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//creat connection
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/rajesh","root","root");
		//create statement object 
		Statement statement=connection.createStatement();
		ResultSet set=statement.executeQuery("select * from emp");
		CachedRowSet rowSet=RowSetProvider.newFactory().createCachedRowSet(); 
		rowSet.populate(set);
		connection.close();
		
		while (rowSet.next()) 
			{
				System.out.println(rowSet.getInt(1)+" "+rowSet.getString(2)+" "+rowSet.getFloat(3));
				
			}				
//		rowSet.populate(set);
//		rowSet.afterLast();
//		while (rowSet.previous()) 
//		{
//			System.out.println(rowSet.getInt(1)+" "+rowSet.getString(2)+" "+rowSet.getFloat(3));
//			
//		}
//		connection.close();
		
		
	}
}
