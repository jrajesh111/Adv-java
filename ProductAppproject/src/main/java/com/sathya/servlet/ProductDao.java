package com.sathya.servlet;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao 
{
	
	
	public int save(Product product) 
	{
		Connection c =null;
		PreparedStatement preparedStatement=null;
		
		int saveResult = 0;
		try {
			c=ProductConnection.proCon();
			preparedStatement = c.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?,?,? )");
			
			preparedStatement.setString(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4,product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6, product.getProMfgDate());
			preparedStatement.setDate(7, product.getProExpDate());
			preparedStatement.setBytes(8, product.getProImage());
			preparedStatement.setBytes(9, product.getProAudio());
			preparedStatement.setBytes(10, product.getProVideo());
			
			
			saveResult= preparedStatement.executeUpdate();
	                    
		}
		catch (SQLException s) 
		{
			
			s.printStackTrace();
		}
		
		finally 
		{
			try {
				if(c!=null && preparedStatement!=null) {
				c.close();
				preparedStatement.close();
				}
			}catch (SQLException s) 
			{
				s.printStackTrace();
			}	
		}
		
		return saveResult;	
	}
	
	public List<Product> findAll()
	{
		List<Product> pro=new ArrayList<Product>();
		
		try(Connection connection=ProductConnection.proCon();
				Statement statement= connection.createStatement())
		{		
			ResultSet resultSet=statement.executeQuery("select * from product_data");
			while(resultSet.next()) 
			{
				Product product=new Product();
				
				product.setProId(resultSet.getString("proId"));
				product.setProName(resultSet.getString("proName"));
				product.setProPrice(resultSet.getDouble("proPrice"));
				product.setProBrand(resultSet.getString("proBrand"));
				product.setProMadeIn(resultSet.getString("proMadeIn"));
				product.setProMfgDate(resultSet.getDate("proMfgDate"));
				product.setProExpDate(resultSet.getDate("proExpDate"));			
				product.setProImage(resultSet.getBytes("proImage"));
				product.setProAudio(resultSet.getBytes("proAudio"));
				product.setProVideo(resultSet.getBytes("proVideo"));
								
				pro.add(product);
			}			
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return pro;				
	}
	
	public int deleteById(String proId) 
	{
		
		int count=0;
			//get the connection
			try(Connection connection =ProductConnection.proCon();
					PreparedStatement preparedStatement =connection.prepareStatement("delete from product_data where proId=?"))
			{
				preparedStatement.setString(1, proId);
				count = preparedStatement.executeUpdate();
			}
			catch (SQLException s) {
				s.printStackTrace();
			}
			return count;
	}
	
	public Product findById(String proId) {
		
		Product product1= null;
		//get connection
		try(Connection connection =ProductConnection.proCon();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from product_data where proId=?"))
		{
			preparedStatement.setString(1, proId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
				if(resultSet.next()) {
					product1=new Product();
					
					product1.setProId(resultSet.getString("proId"));
					product1.setProName(resultSet.getString("proName"));
					product1.setProPrice(resultSet.getDouble("proPrice"));
					product1.setProBrand(resultSet.getString("proBrand"));
					product1.setProMadeIn(resultSet.getString("proMadeIn"));
					product1.setProMfgDate(resultSet.getDate("proMfgDate"));
					product1.setProExpDate(resultSet.getDate("proExpDate"));
					product1.setProImage(resultSet.getBytes("proImage"));
					product1.setProAudio(resultSet.getBytes("proAudio"));
					product1.setProVideo(resultSet.getBytes("proVideo"));					
				}
			}
		catch (SQLException s) 
		{
			s.printStackTrace();
		}
		return product1;	
	}
	public   int updateById(Product product)
	{
		
		int updateResult=0;
		
		try(Connection connection=ProductConnection.proCon();
				PreparedStatement preparedStatement=connection.prepareStatement("update product_data set proName=?,proPrice=?,proBrand=?,proMadeIn=?,proMfgDate=?,proExpDate=?, proImage=? ,proAudio=?, proVideo=? where proId=? "))
		{
			preparedStatement.setString(1,product.getProName());
			preparedStatement.setDouble(2, product.getProPrice());
			preparedStatement.setString(3, product.getProBrand());
			preparedStatement.setString(4, product.getProMadeIn());
			preparedStatement.setDate(5, product.getProMfgDate());
			preparedStatement.setDate(6, product.getProExpDate());
			preparedStatement.setBytes(7, product.getProImage());
			preparedStatement.setBytes(8, product.getProAudio());
			preparedStatement.setBytes(9, product.getProVideo());
			preparedStatement.setString(10, product.getProId());
			
			updateResult=preparedStatement.executeUpdate();
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		return updateResult;
	}	
}
