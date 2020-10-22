package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;

public class DeleteProductAction extends RequestHandler{

	public DeleteProductAction()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		if (request.getParameter("delete") != null)
		{
			getService().deleteProduct(request.getParameter("productname"));
		}

		request.setAttribute("productList", getService().getProducts());
		
		request.getRequestDispatcher("productoverview.jsp").forward(request, response);
	}
	
	@Override
	public Role[] getAccessList() {
		return new Role[]{Role.ADMINISTRATOR};
	}

}
