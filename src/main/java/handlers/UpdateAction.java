package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import domain.Role;

public class UpdateAction extends RequestHandler{

	public UpdateAction()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String destination;

		String productId = request.getParameter("productid");
		String desc = request.getParameter("description");
		String price = request.getParameter("price");

		if (productId.isEmpty() || desc.isEmpty() || price.isEmpty())
		{
			destination = "update.jsp";
			request.setAttribute("warning", "incomplete");
			request.setAttribute("product", getService().getProduct(productId));
		} else
		{
			try
			{
				getService().getProduct(productId).setDescription(desc);
				double doublePrice = Double.parseDouble(price);
				getService().getProduct(productId).setPrice(doublePrice);
				getService().deleteProduct(productId);
				getService().addProduct(new Product(productId, desc, doublePrice));
				destination = "index.jsp";
			} catch (NumberFormatException e)
			{
				request.setAttribute("warning", "illegalNumber");
				request.setAttribute("product", getService().getProduct(productId));
				destination = "update.jsp";
			}

		}
		request.getRequestDispatcher(destination).forward(request, response);
	}
	
	@Override
	public Role[] getAccessList() {
		return new Role[]{Role.ADMINISTRATOR};
	}

}
