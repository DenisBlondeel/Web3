package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import domain.Role;

public class IndexPage extends RequestHandler{

	public IndexPage()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("user");
		if(person != null)
		{
			request.setAttribute("login", "istrue");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	@Override
	public Role[] getAccessList() {
		return null;
	}

}
