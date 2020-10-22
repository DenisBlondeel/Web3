package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;

public class LogoutAction extends RequestHandler{

	public LogoutAction()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getSession().invalidate();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	@Override
	public Role[] getAccessList()
	{
		return null;
	}

}
