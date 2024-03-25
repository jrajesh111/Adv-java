package jdbcconnection;

public class JdbcEx {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded Succesfully");
	}

}
