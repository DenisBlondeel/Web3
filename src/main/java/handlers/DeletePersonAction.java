package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;

public class DeletePersonAction extends RequestHandler{

	public DeletePersonAction()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		if (request.getParameter("delete") != null)
		{
			getService().deletePerson(request.getParameter("name"));
		}

		request.setAttribute("list", getService().getPersons());	
		request.getRequestDispatcher("personoverview.jsp").forward(request, response);
	}
	
	@Override
	public Role[] getAccessList() {
		return new Role[]{Role.ADMINISTRATOR};
	}

}
