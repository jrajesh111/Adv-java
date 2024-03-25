package procidurefunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class BatchPrecedureEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rajesh","rajesh");
					//call procedure
		Statement statement=connection.createStatement();
		
		//statement.addBatch("create table stu(id number,name varchar2(10),branch varchar2(10))");
//		statement.addBatch("insert into stu values(1,'rajesh','ite')");
//		statement.addBatch("insert into stu values(2,'gani','ece')");
//		statement.addBatch("insert into stu values(3,'suri','cse')");
//		statement.addBatch("insert into stu values(4,'mahi','Agri')");
		statement.addBatch("delete from stu where id in(3)");
		
		int results[]=statement.executeBatch();
		for(int res:results)
		{
			System.out.println(res);
		}
		connection.close();		
	}

}
