package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;

public class DeletePersonPage extends RequestHandler{

	public DeletePersonPage()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String userid = request.getParameter("name");
		request.setAttribute("person", getService().getPerson(userid));
		request.getRequestDispatcher("deleteperson.jsp").forward(request, response);
	}
	
	@Override
	public Role[] getAccessList() {
		return new Role[]{Role.ADMINISTRATOR};
	}

}
