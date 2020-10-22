package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Cart;
import domain.ProductOrder;

public class CartPage extends RequestHandler{

	public CartPage()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		request.setAttribute("total", cart.getTotalPrice());
		request.setAttribute("cartlist", cart.getProductsOrdered());
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
	}

}
