package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;

public class ChangeColorAction extends RequestHandler{

	public ChangeColorAction()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Cookie cookie = null;
		
		String page = request.getParameter("page");
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies)
		{
			if(c.getName().equals("color")) cookie = c;
		}
		if(cookie == null || cookie.getValue().equals("yellow"))
		{
			Cookie c = null;
			 c = new Cookie("color", "red");
			response.addCookie(c);
		}
		else
		{
			Cookie c = null;
			cookie.setMaxAge(0);
			 c = new Cookie("color", "yellow");
			response.addCookie(c);
		}
		response.sendRedirect("Controller?action=" + page);
	}
	
	@Override
	public Role[] getAccessList()
	{
		return null;
	}

}
