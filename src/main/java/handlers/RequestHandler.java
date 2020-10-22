package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.NotAuthorizedException;
import domain.Person;
import domain.Role;
import service.ShopService;

public abstract class RequestHandler {
	
	private ShopService service;

	public RequestHandler(){};
	
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
		checkAuthorisation(request);
		checkCookie(request);
		handleRequest(request, response);
		}
		catch(NotAuthorizedException e)
		{
			request.setAttribute("errors", e.getMessage());
			request.getRequestDispatcher("Controller?action=default").forward(request, response);
		}
	}
	
	public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void checkAuthorisation(HttpServletRequest request) 
	{
		if(getAccessList() == null)
		{
			return;
		}
		
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("user");
		
		if(person == null)
		{
			throw new NotAuthorizedException("Onvoldoende rechten");
		}
		
		for (Role role : getAccessList()) {
			if (person.getRole().equals(role)) {
				return;
			}
		}
		throw new NotAuthorizedException("Onvoldoende rechten");
		
	}
	
	public void checkCookie(HttpServletRequest request) throws ServletException, IOException
	{
		Cookie cookie = null;
		
		Cookie[] cookies = request.getCookies();
		if(cookies == null)
		{
			request.setAttribute("style", "yellow");
			return;
		}
		for(Cookie c : cookies)
		{
			if(c.getName().equals("color")) cookie = c;
		}
		
		if(cookie == null || cookie.getValue().equals("yellow"))
		{
			request.setAttribute("style", "yellow");
		}
		else
		{
			request.setAttribute("style", "red");
		}
	}
	
	public void setService(ShopService service)
	{
		this.service = service;
	}
	
	protected ShopService getService()
	{
		return service;
	}
	
	protected Role[] getAccessList()
	{
		return null;
	}

}
