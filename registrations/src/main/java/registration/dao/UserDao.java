package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import  registration.model.User;

public class UserDao {
	
	public int registerUser(User user) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO user" +
	            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "Wesley@949");

	           
	        		// Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setString(1, user.getUser_name());
	            preparedStatement.setString(2, user.getUser_email());
	            preparedStatement.setString(3, user.getMobile());
	            preparedStatement.setString(4, user.getUser_password());
	           
	            System.out.println(preparedStatement);
	            
	            
	            
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        }
	        catch (SQLException e)
	        {
	            // process sql exception
	        	
	           e.printStackTrace();
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex)
	    {
	        for (Throwable e: ex) 
	        {
	            if (e instanceof SQLException) 
	            {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                
	                while (t != null)
	                {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}

