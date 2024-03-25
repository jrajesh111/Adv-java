package com.sathya.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/rajesh","root","root");
		
		//Making the Resultset scroolable & updatable
		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		//execute the select query &store the data in resultset
		ResultSet set=statement.executeQuery("select * from emp");
		//reading all recourds backword direction
		
		set.afterLast();//moving the cursor to after last record
		while(set.previous())
		{
			System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
		}
		
		//cursor is pointing to first record
		set.first();
		System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
		//cursor is pointing to specific record
		set.last();
		System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
		
		//cursor is pointing to specific record
		set.absolute(2);
		System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3));
		
		connection.close();
		System.out.println("Connection realesed ....");
	}

}
