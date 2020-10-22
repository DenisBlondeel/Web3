package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Cart;
import domain.Product;
import domain.Role;

public class AddToCartAction extends RequestHandler{

	public AddToCartAction()
	{
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String productId = request.getParameter("id");
		String qdt = request.getParameter("quantity");
		int quantity = Integer.parseInt(qdt);
		Product product = getService().getProduct(productId);
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.addProduct(product, quantity);
		
		response.sendRedirect("Controller?action=productoverview");
	}
	
	@Override
	public Role[] getAccessList()
	{
		return new Role[]{Role.CUSTOMER, Role.ADMINISTRATOR};
	}

}
