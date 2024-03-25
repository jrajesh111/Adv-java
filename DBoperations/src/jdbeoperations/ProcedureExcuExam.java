package jdbeoperations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureExcuExam {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","rajesh","rajesh");
		//call procedure
				CallableStatement callableStatement=connection.prepareCall("{Call getDetail(?,?,?,?)}");
				
				//set the input data
				callableStatement.setInt(1, 102);
			
				//register one vareable to store the output
				callableStatement.registerOutParameter(2,Types.INTEGER );
				
				callableStatement.registerOutParameter(3,Types.VARCHAR);
				callableStatement.registerOutParameter(4,Types.FLOAT);
				//execute the procedure the output will be stored in registred parameter
				callableStatement.executeUpdate();
				
				//print the output
				System.out.println(callableStatement.getInt(2)+" "+callableStatement.getString(3)+" "+callableStatement.getFloat(4));
		
		
	}

}
