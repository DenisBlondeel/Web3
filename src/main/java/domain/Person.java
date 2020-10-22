package domain;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
	private String userid;
	private String email;
	private String firstName;
	private String lastName;

	private String salt;
	private String password;

	private Role role;

	public Person(String userid, String email, String password, String firstName, String lastName)
	{
		setUserid(userid);
		setEmail(email);
		setPasswordHashed(password);
		setFirstName(firstName);
		setLastName(lastName);
	}

	public Person(){}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		if (userid.isEmpty())
		{
			throw new IllegalArgumentException("Geen userID gegeven");
		}
		this.userid = userid;
	}

	public void setEmail(String email)
	{
		if (email.isEmpty()|| email == null)
		{
			throw new IllegalArgumentException("Geen email gegeven");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(email);
		if (!m.matches())
		{
			throw new IllegalArgumentException("Email ongeldig");
		}
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		if (firstName.isEmpty())
		{
			throw new IllegalArgumentException("Geen voornaam gegeven");
		}
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		if (lastName.isEmpty())
		{
			throw new IllegalArgumentException("Geen achternaam gegeven");
		}
		this.lastName = lastName;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		if (role == null)
		{
			throw new IllegalArgumentException("No role given");
		}
		try {
			this.role = Role.valueOf(role.toUpperCase());
		} catch (Exception e) {
			throw new IllegalArgumentException("De gegeven role bestaat niet");
		}
	}
	
	public void setRole(Role role)
	{
		this.role = role;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		if (password == null || password.isEmpty())
		{
			throw new IllegalArgumentException("Gelieve een wachtwoord op te geven");
		}
		this.password = password;
	}

	public void setPasswordHashed(String password)
	{
		if (password.isEmpty())
		{
			throw new IllegalArgumentException("Geen wachtwoord gegeven");
		}
		try
		{
			if (getSalt() == null)
			{
				createSalt();
			}
			this.password = hashPassword(password);
		}
		catch (Exception e)
		{
			throw new IllegalArgumentException("Systeem kon geen hashed wachtwoord creeren");
		}
	}

	public String hashPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();

		crypt.update(getSalt().getBytes("UTF-8"));
		crypt.update(password.getBytes("UTF-8"));

		byte[] digest = crypt.digest();
		return new BigInteger(1, digest).toString(16);
	}

	public boolean isCorrectPassword(String password)
	{
		if (password.isEmpty())
		{
			throw new IllegalArgumentException("Geen wachtwoord gegeven");
		}
		try
		{
			return getPassword().equals(hashPassword(password));
		}
		catch (Exception e)
		{
			throw new IllegalArgumentException("Systeem kon geen hashed wachtwoord creeren");
		}
	}

	public void setSalt(String salt)
	{
		if (salt == null || salt.isEmpty())
		{
			throw new IllegalArgumentException("De salt voor het inloggen is niet ingevuld");
		}
		this.salt = salt;
	}

	public String getSalt()
	{
		return salt;
	}

	private void createSalt()
	{
		SecureRandom random = new SecureRandom();
		byte seed[] = random.generateSeed(20);
		setSalt(new BigInteger(1, seed).toString(16));
	}
}
