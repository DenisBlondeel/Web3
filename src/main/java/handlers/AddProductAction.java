package handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import domain.Role;

public class AddProductAction extends RequestHandler{

	public AddProductAction()
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
		
		if(productId.isEmpty())
		{
			destination = "addproduct.jsp";
			request.setAttribute("warning", "productid");
			request.setAttribute("description", desc);
			request.setAttribute("price", price);
		}
		else if(desc.isEmpty())
		{
			destination = "addproduct.jsp";
			request.setAttribute("warning", "description");
			request.setAttribute("productid", productId);
			request.setAttribute("price", price);
		}
		else if(price.isEmpty())
		{
			destination = "addproduct.jsp";
			request.setAttribute("warning", "price");
			request.setAttribute("productid", productId);
			request.setAttribute("description", desc);
		}
		else{
			double doublePrice = Integer.parseInt(price);
			getService().addProduct(new Product(productId, desc, doublePrice));
			destination = "index.jsp";
		}
		request.getRequestDispatcher(destination).forward(request, response);		
	}
	
	@Override
	public Role[] getAccessList() {
		return new Role[]{Role.ADMINISTRATOR};
	}

}
