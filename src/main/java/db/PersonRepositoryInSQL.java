package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.Person;

public class PersonRepositoryInSQL implements PersonRepository {

	private Connection connection;
	private PreparedStatement statement;

	public PersonRepositoryInSQL()
	{
		Properties properties = new Properties();
		String url = "jdbc:postgresql://gegevensbanken.khleuven.be:51516/2TX33";
		properties.setProperty("user", "r0372092");
		properties.setProperty("password", "******");
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
	public Person get(String personId)
	{
		if (personId.isEmpty())
		{
			throw new DbException("nothing to find");
		}
		String sql = "SELECT * " + "FROM r0372092.persons" + " WHERE userid = ?;";
		Person person = new Person();
		try
		{
			statement = connection.prepareStatement(sql);
			statement.setString(1, personId);
			ResultSet results = statement.executeQuery();
			if(results.next()){
			person.setUserid(results.getString("userid"));
			person.setEmail(results.getString("email"));
			person.setLastName(results.getString("lastname"));
			person.setFirstName(results.getString("firstname"));
			person.setPassword(results.getString("password"));
			person.setRole(results.getString("role"));
			person.setSalt(results.getString("salt"));
			}
		} catch (SQLException e)
		{
			throw new DbException(e.getMessage(), e);
		}

		return person;
	}
	
	@Override
	public Person getIfAuthenticated(String personId, String password)
	{	Person person = get(personId);
		if(person.isCorrectPassword(password))
		{
			return person;
		}
		else return null; 
	}

	@Override
	public List<Person> getAll()
	{
		List<Person> list = new ArrayList<Person>();
		String sql = "SELECT *" + " FROM r0372092.persons";
		try
		{
			statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while (results.next())
			{
				Person person = new Person();
				person.setUserid(results.getString("userid"));
				person.setEmail(results.getString("email"));
				person.setLastName(results.getString("lastname"));
				person.setFirstName(results.getString("firstname"));
				person.setSalt(results.getString("salt"));
				person.setRole(results.getString("role"));
				person.setPassword(results.getString("password"));
				list.add(person);
			}
		} catch (SQLException e)
		{
			throw new DbException(e);
		}
		return list;
	}

	@Override
	public void add(Person person)
	{
		if (person == null)
		{
			throw new DbException("nothing to add !");
		}
		String sql = "INSERT INTO r0372092.persons (userid, email, password, salt, lastname, firstname, role)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

		try
		{
			statement = connection.prepareStatement(sql);
			statement.setString(1, person.getUserid());
			statement.setString(2, person.getEmail());
			statement.setString(3, person.getPassword());
			statement.setString(4, person.getSalt());
			statement.setString(5, person.getLastName());
			statement.setString(6, person.getFirstName());
			statement.setString(7, person.getRole().toString());
			statement.execute();
		} catch (SQLException e)
		{
			throw new DbException(e);
		}

	}

	@Override
	public void update(Person person)
	{
	}

	@Override
	public void delete(String personId)
	{
		if (personId.isEmpty())
		{
			throw new DbException("nothing to delete !");
		}

		String sql = "DELETE " + "FROM r0372092.persons " + "WHERE userid = ?";

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

	public boolean exists(String personId)
	{
		if (personId.isEmpty())
		{
			throw new DbException("nothing to find");
		}
		Boolean exists = true;
		String sql = "SELECT * " + "FROM r0372092.persons" + " WHERE userid = ?;";
		try
		{
			statement = connection.prepareStatement(sql);
			statement.setString(1, personId);
			ResultSet results = statement.executeQuery();
			results.next();
			if(results != null)
			{
				exists = false;
			}
		} catch (SQLException e)
		{
			throw new DbException(e);
		}
		return exists;
	}

}
