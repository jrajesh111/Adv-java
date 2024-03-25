package procidurefunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionExecution {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","rajesh","rajesh");
						//call procedure
				CallableStatement callableStatement=connection.prepareCall("{ ? = call getAvg(?,?)}");
				
				//set the input data
				callableStatement.setInt(2, 102);
				callableStatement.setInt(3, 103);
				
				//register one vareable to store the output
				callableStatement.registerOutParameter(1, Types.DOUBLE);
				
				//Execute the procedure the output will be stored in registred parameter
				callableStatement.executeUpdate();
				
				//print output
				System.out.println(callableStatement.getDouble(1));
				
				connection.close();
	}

}
