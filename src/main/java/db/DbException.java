package db;

import java.sql.SQLException;

public class DbException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public DbException() {
		super();
	}
	
	public DbException(String s)
	{
		super(s);
	}
	
	public DbException(String s, SQLException e)
	{
		super(s, e);
	}
	
	public DbException(String s, ClassNotFoundException e)
	{
		super(s, e);
	}
	
	public DbException(SQLException e)
	{
		super(e);
	}

}
