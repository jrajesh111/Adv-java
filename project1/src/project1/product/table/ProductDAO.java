package project1.product.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO 
{
	public int save(Product p) 
	{
		Connection c =null;
		PreparedStatement ps=null;
		
		int count = 0;
		try {
			c=Productconnect.proConn();
			ps = c.prepareStatement("insert into pro values(?,?,?)");
			ps.setInt(1, p.getProductid());
			ps.setString(2, p.getProductName());
			ps.setDouble(3, p.getProductPrice());
			
			count = ps.executeUpdate();
			System.out.println("rowCount "+count);
		}
		catch (SQLException s) 
		{
			
			s.printStackTrace();
		}
		finally 
		{
			try {
				if(c!=null && ps!=null) {
				c.close();
				ps.close();
				}
			}catch (SQLException s) 
			{
				s.printStackTrace();
			}	
		}
		return count;	
	}
	
	public Product findById(int productid) {
		Product pro= null;
		//get connection
		try(Connection connection =Productconnect.proConn();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from pro where productid=?"))
		{
			preparedStatement.setInt(1, productid);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				pro = new Product();
				pro.setProductid(resultSet.getInt(1));
				pro.setProductName(resultSet.getString(2));
				pro.setProductPrice(resultSet.getDouble(3));
			}
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		return pro;
	}
	
	public int deleteByPrice(int productPrice) {
		
		int count=0;
		
		//get the connection.
		try(Connection connection =Productconnect.proConn();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from pro where productPrice>?")){
			
			preparedStatement.setInt(1,productPrice);
			
			count = preparedStatement.executeUpdate();			
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return count;
	}
	
	
	public int deleteById(int productid) 
	{
		int count=0;
			//get the connection
			try(Connection connection =Productconnect.proConn();
					PreparedStatement preparedStatement =connection.prepareStatement("delete from pro where productid=?"))
			{
				preparedStatement.setInt(1, productid);
				count = preparedStatement.executeUpdate();
			}
			catch (SQLException s) {
				s.printStackTrace();
			}
			return count;
	}
	
	public List<Product> findaAll()
	{
		List<Product> pro=new ArrayList<Product>();
		
		try(Connection connection=Productconnect.proConn();
				Statement statement= connection.createStatement())
		{		
			ResultSet resultSet=statement.executeQuery("select * from pro");
			while(resultSet.next()) 
			{
				Product product=new Product();
				product.setProductid(resultSet.getInt(1));
				product.setProductName(resultSet.getString(2));
				product.setProductPrice(resultSet.getDouble(3));
				pro.add(product);
			}			
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return pro;				
	}
	
	public static  int updatePrice(double currentPrice,double incPrice)
	{
		int count=0;
		
		try(Connection connection=Productconnect.proConn();
				PreparedStatement preparedStatement=connection.prepareStatement("update pro set productPrice=productPrice+? where productPrice>? "))
		{
			preparedStatement.setDouble(1,currentPrice);
			preparedStatement.setDouble(2, incPrice);
			count=preparedStatement.executeUpdate();
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		return count;
	}
	
}
