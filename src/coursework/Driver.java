package coursework;

import java.io.*;

public class Driver implements Serializable {
	private Depot depot;

	private String name;
	String password;

	public Driver(String name, String password)	{
		this.name = name;
		this.password = password;
	}
	
	public String toString()	{
		return ("Name: " + name + "Password" + password);
	}
	
	public String getName()	{
		return name;
	}
	
	public String getPassword()	{
		return password;
	}
	
	public boolean checkPassword(String pass)	{
		if (pass == password)	{
			return true;
		}
		else	{
			return false;
		}
	
	
	}
	
	
	

	
	
	private Boolean IsAvailable()	{
		return null;
		
	}
	
	private void SetSchedule()	{
		
	}




}


