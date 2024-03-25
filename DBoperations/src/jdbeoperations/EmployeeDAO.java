package jdbeoperations;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.p;

public class EmployeeDAO {
	public int save(Employee e) 
	{
		Connection c =null;
		PreparedStatement ps=null;
		
		int count = 0;
		try {
			c=DbConnection.dbConnect();
			ps = c.prepareStatement("insert into emp values(?,?,?)");
			ps.setInt(1, e.getEmpid());
			
			ps.setString(2, e.getEmpName());
			ps.setDouble(3, e.getEmpSalary());
			
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

	public Employee findById(int empId) {
		Employee emp= null;
		//get connection
		try(Connection connection =DbConnection.dbConnect();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from emp where empid=?"))
		{
			preparedStatement.setInt(1, empId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				emp = new Employee();
				emp.setEmpid(resultSet.getInt(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setEmpSalary(resultSet.getDouble(3));
			}
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		return emp;
	}
	
	
	public int deleteById(int empid) 
	{
		int count=0;
			//get the connection
			try(Connection connection =DbConnection.dbConnect();
					PreparedStatement preparedStatement =connection.prepareStatement("delete from emp where empid=?"))
			{
				preparedStatement.setInt(1, empid);
				count = preparedStatement.executeUpdate();
			}
			catch (SQLException s) {
				s.printStackTrace();
			}
			return count;
	}
	
	public int deleteBySalary(int empsalary) {
		
		int count=0;
		
		//get the connection.
		try(Connection connection = DbConnection.dbConnect();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from emp where empSalary<?")){
			
			preparedStatement.setInt(1,empsalary);
			
			count = preparedStatement.executeUpdate();			
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return count;
	}
	public List<Employee> findaAll()
	{
		List<Employee> emps=new ArrayList<Employee>();
		
		try(Connection connection=DbConnection.dbConnect();
				Statement statement= connection.createStatement())
		{
					
		
			ResultSet resultSet=statement.executeQuery("select * from emp");
			while(resultSet.next()) 
			{
				Employee employee=new Employee();
				employee.setEmpid(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				emps.add(employee);
			}			
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
		return emps;				
	}
	public static  int updateSalary(double currentSalary,double incSalary)
	{
		int count=0;
		
		try(Connection connection=DbConnection.dbConnect();
				PreparedStatement preparedStatement=connection.prepareStatement("update emp set empSalary=empSalary+? where empSalary>? "))
		{
			preparedStatement.setDouble(1,currentSalary);
			preparedStatement.setDouble(2, incSalary);
			count=preparedStatement.executeUpdate();
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		return count;
	}
}


	

