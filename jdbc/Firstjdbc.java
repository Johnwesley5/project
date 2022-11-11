//jdbc connection
import java.sql.*;
class FirstJdbc{
	public static void main(String[] args)throws SQLException,ClassNotFoundException
	{
		//1) Create connection
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/registrations";
			String username ="root";
			String password = "Wesley@949";
			
			Connection con = DriverManager.getConnection(url,username,password);
	
		//2) Create statement/Query
		Statement stmt = con.createStatement();
		String s="INSERT INTO USERS VALUES(1,'wesley','john@123','9390630031','abcd123')";
		
		//3) Execute statement/Query
		stmt.execute(s);
		
		//4) close connection
		con.close();
	
	}
}