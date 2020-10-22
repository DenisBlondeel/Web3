package handlers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cart;
import domain.Person;
import domain.Role;

public class LoginAction extends RequestHandler{

	public LoginAction()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Person person = getService().getPersonIfAuthenticated(username, password);
		if(person == null)
		{
			request.setAttribute("errors","Onjuist wachtwoord of username");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
		request.setAttribute("success","Welkom " + person.getFirstName() + " " + person.getLastName());
		HttpSession session = request.getSession();
		session.setAttribute("cart", new Cart());
		session.setAttribute("user", person);
		request.setAttribute("login", "istrue");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	@Override
	public Role[] getAccessList()
	{
		return null;
	}

}
