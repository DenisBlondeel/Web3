package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;

public class ProductOverview extends RequestHandler{

	public ProductOverview()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setAttribute("productList", getService().getProducts());
		request.getRequestDispatcher("productoverview.jsp").forward(request, response);
		
	}
	
	@Override
	public Role[] getAccessList() {
		return new Role[]{Role.CUSTOMER, Role.ADMINISTRATOR};
	}

}
