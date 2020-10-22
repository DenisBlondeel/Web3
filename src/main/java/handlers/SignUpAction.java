package handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import domain.Role;

public class SignUpAction extends RequestHandler{

	public SignUpAction()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Person person = new Person();
		List<String> errors = new ArrayList<String>();
		checkInput(person, request, errors);
		
		if(errors.size() > 0)
		{
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		}
		else
		{
				request.setAttribute("success", person.getFirstName() + " " + person.getLastName() + " toegevoegd !");
				getService().addPerson(person);
				HttpSession session = request.getSession();
				session.setAttribute("user", person);
				request.getRequestDispatcher("Controller?action=overview").forward(request, response);
		}
		
	}
	
	private void checkInput(Person person, HttpServletRequest request, List<String> errors)
	{
		setUid(person, request, errors);
		setFirstName(person, request, errors);
		setLastName(person, request, errors);
		setEmail(person, request, errors);
		setPassword(person, request, errors);
	}
	
	private void setUid(Person person, HttpServletRequest request, List<String> errors)
	{
		String uid = request.getParameter("userid");
		request.setAttribute("prevUid", uid);
		try
		{
			person.setUserid(uid);
			person.setRole(Role.CUSTOMER);
		}
		catch(IllegalArgumentException e)
		{
			errors.add(e.getMessage());
		}
	}
	
	private void setFirstName(Person person, HttpServletRequest request, List<String> errors)
	{
		String firstName = request.getParameter("firstName");
		request.setAttribute("prevFirstName", firstName);
		try
		{
			person.setFirstName(firstName);;
		}
		catch(IllegalArgumentException e)
		{
			errors.add(e.getMessage());
		}
	}
	
	private void setLastName(Person person, HttpServletRequest request, List<String> errors)
	{
		String lastName = request.getParameter("lastName");
		request.setAttribute("prevLastName", lastName);
		try
		{
			person.setLastName(lastName);;
		}
		catch(IllegalArgumentException e)
		{
			errors.add(e.getMessage());
		}
	}
	
	private void setEmail(Person person, HttpServletRequest request, List<String> errors)
	{
		String email = request.getParameter("email");
		request.setAttribute("prevEmail", email);
		try
		{
			person.setEmail(email);
		}
		catch(IllegalArgumentException e)
		{
			errors.add(e.getMessage());
		}
	}
	
	private void setPassword(Person person, HttpServletRequest request, List<String> errors)
	{
		String password = request.getParameter("password");
		try
		{
			person.setPasswordHashed(password);
		}
		catch(IllegalArgumentException e)
		{
			errors.add(e.getMessage());
		}
	}
	
	@Override
	public Role[] getAccessList() {
		return null;
	}

}
