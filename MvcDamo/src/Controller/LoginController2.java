package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController2")
public class LoginController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Modal.LoginModal loginObj=new Modal.LoginModal();
		loginObj.setUsername(username);
		loginObj.setPassword(password);
		
		if(loginObj.chekLogin())
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("Success.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("Failed.jsp");
			dispatch.forward(request, response);
		}
		
		
	}

}
