package mvc.dao;

import java.sql.*;

import registration.model.User;


public class Userdao {
	
	public int registerUser(User user) throws ClassNotFoundException {
	        String user_name = user.getName();
	        String user_email = user.getEmail();
	        int mobile = user.getMobile();
	        String user_password = user.getPassword();
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/registrations";
			String username ="root";
			String password = "Wesley@949";
			
			Connection con = DriverManager.getConnection(url,username,password);
			
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = con.preparedStatement(INSERT_INTO_USERS_SQL); {
	            preparedStatement.setInt(1, 1);
				preparedStatement.setString(2, user.getName());
	            preparedStatement.setString(3, user.getEmail());
	            preparedStatement.setString(4, user.getMobile());
	            preparedStatement.setString(5, user.getPassword());
	            
	            System.out.println(preparedStatement);
	            
	            
	            // Step 3: Execute the query or update query
	             result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	           e.printStackTrace();
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}
	}

}

