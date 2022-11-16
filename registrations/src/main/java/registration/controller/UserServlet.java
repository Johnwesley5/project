package registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registration.dao.UserDao;
import registration.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName= request.getParameter("userName");
		String userEmail= request.getParameter("userEmail");
		String mobile= request.getParameter("mobile");
		String userPassword= request.getParameter("userPassword");
		
		User user = new User();
		user.setUser_email(userName);
		user.setUser_email(userEmail);
		user.setMobile(mobile);
		user.setUser_password(userPassword);
		
		try {
			
		
		userDao.registerUser(user);
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		response.sendRedirect(userPassword)
		
	}

}
