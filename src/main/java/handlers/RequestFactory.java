package handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;

import service.ShopService;

public class RequestFactory {
	
	private Map<String, RequestHandler> handlers = new HashMap<String, RequestHandler>();

	public RequestFactory(Properties handlerList, ShopService service) throws ServletException
	{
		for(Object key : handlerList.keySet())
		{
			RequestHandler handler = null;
			String handlerName = handlerList.getProperty((String)key);
			
			try
			{
				Class<?> handlerClass = Class.forName(handlerName);
				Object handlerObject = handlerClass.newInstance();
				handler = (RequestHandler) handlerObject;
			}
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e.getMessage(), e);
			}
			handler.setService(service);
			handlers.put((String)key, handler);
		}
	}
	
	public RequestHandler getRequestHandler(String name)
	{
		return handlers.get(name);
	}

}
