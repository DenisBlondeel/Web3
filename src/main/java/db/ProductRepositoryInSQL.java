package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.Product;

public class ProductRepositoryInSQL implements ProductRepository {

	private Connection connection;
	private PreparedStatement statement;

	public ProductRepositoryInSQL()
	{
		Properties properties = new Properties();
		String url = "jdbc:postgresql://gegevensbanken.khleuven.be:51516/2TX33";
		properties.setProperty("user", "r0372092");
		properties.setProperty("password", "*****");
		properties.setProperty("ssl", "true");
		properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
		try
		{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e)
		{
			throw new DbException(e.getMessage(), e);
		} catch (ClassNotFoundException e)
		{
			throw new DbException(e.getMessage(), e);
		}
	}

	@Override
	public Product get(String productId)
	{
		if (productId.isEmpty())
		{
			throw new DbException("nothing to find");
		}
		String sql = "SELECT * " + "FROM r0372092.products" + " WHERE productid = ?";
		Product product = new Product();
		try
		{
			statement = connection.prepareStatement(sql);
			statement.setString(1, productId);
			ResultSet results = statement.executeQuery();
			results.next();
			product.setProductId(results.getString("productid"));
			product.setDescription(results.getString("description"));
			product.setPrice(results.getDouble("price"));

		} catch (SQLException e)
		{
			throw new DbException(e.getMessage(), e);
		}

		return product;
	}

	@Override
	public List<Product> getAll()
	{
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT *" + " FROM r0372092.products";
		try
		{
			statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while (results.next())
			{
				Product product = new Product();
				product.setProductId(results.getString("productid"));
				product.setDescription(results.getString("description"));
				product.setPrice(results.getDouble("price"));
				list.add(product);
			}
		} catch (SQLException e)
		{
			throw new DbException(e);
		}
		return list;
	}

	@Override
	public void add(Product product)
	{
		if (product == null)
		{
			throw new DbException("nothing to add !");
		}
		String sql = "INSERT INTO r0372092.products (productid, description, price)" + " VALUES (?, ?, ?)";

		try
		{
			statement = connection.prepareStatement(sql);
			statement.setString(1, product.getProductId());
			statement.setString(2, product.getDescription());
			statement.setDouble(3, product.getPrice());
			statement.execute();
		} catch (SQLException e)
		{
			throw new DbException(e);
		}

	}

	@Override
	public void update(Product product)
	{
		String sql = "UPDATE r0372092.products " + "SET description = ?, price = ?  " + "WHERE productid = ?;";
		try
		{
			statement = connection.prepareStatement(sql);
			statement.setString(1, product.getDescription());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getProductId());
			System.out.println("starting update sql with value: " + product.getDescription());
			System.out.println("");
			statement.executeUpdate();
		} catch (SQLException e)
		{
			throw new DbException(e.getMessage(), e);
		}
	}

	@Override
	public void delete(String personId)
	{
		if (personId.isEmpty())
		{
			throw new DbException("nothing to delete !");
		}

		String sql = "DELETE " + "FROM r0372092.products " + "WHERE productid = ?";
		try
		{
			statement = connection.prepareStatement(sql);
			statement.setString(1, personId);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			throw new DbException(e);
		}

	}
}