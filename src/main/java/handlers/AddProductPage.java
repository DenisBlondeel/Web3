package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;

public class AddProductPage extends RequestHandler {

	public AddProductPage()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getRequestDispatcher("addproduct.jsp").forward(request, response);;
	}
	
	@Override
	public Role[] getAccessList() {
		return new Role[]{Role.ADMINISTRATOR};
	}

}
