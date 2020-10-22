package ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import domain.Product;
import handlers.RequestFactory;
import handlers.RequestHandler;
import service.ShopService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ShopService service = new ShopService();
	private RequestFactory factory;
	
	@Override
	public void init()throws ServletException
	{
		super.init();
		ServletContext context = getServletContext();
		
		try{
			InputStream input = context.getResourceAsStream("/WEB-INF/handlers.xml");
			Properties handlerList = new Properties();
			handlerList.loadFromXML(input);
			factory = new RequestFactory(handlerList, service);
		}
		catch(Exception e)
		{
			throw new ServletException(e.getMessage(), e);
		}
		
	}

	public Controller()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		String action = request.getParameter("action");
		if(action == null) action="default";
		RequestHandler handler = factory.getRequestHandler(action);
		handler.handle(request, response);
		

	}
}
