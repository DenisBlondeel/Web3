package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Role;

public class DeleteProductPage extends RequestHandler{

	public DeleteProductPage()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String productId = request.getParameter("name");
		request.setAttribute("product", getService().getProduct(productId));
		request.getRequestDispatcher("delete.jsp").forward(request, response);
	}
	
	@Override
	public Role[] getAccessList() {
		return new Role[]{Role.ADMINISTRATOR};
	}

}
