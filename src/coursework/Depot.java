package coursework;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import coursework.Driver;


public class Depot implements Serializable	{
	private String location;
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	public List<Driver> drivers = new ArrayList<Driver>();
	private List<WorkSchedule> workschedules = new ArrayList<WorkSchedule>();
	
	public Depot(String depot)	{
	  this.location = depot;
	}
	
	public String toString()	{
		return location;
	}
	
	public String getDepotName()	{
		return location;
	}
	
	public boolean PrintArray()	{
		return drivers.isEmpty();
	}
	
	public void makeVehicle(Vehicle vehicle)	{
		vehicles.add(vehicle);
	}
	
	public void makeDriver(Driver driver)	{
		drivers.add(driver);
	}
	
	public synchronized void makeSchedule(WorkSchedule workschedule)	{
		workschedules.add(workschedule);
		
		//Two 
		workschedule.getVehicle().makeSchedule(workschedule);
			
	}
	
	public void viewVehicles()	{
		System.out.print(vehicles.toString());
	}
	
	public Driver getDriverByName(String username)	{
		for (Driver d : drivers)	{
			if (d.getName().equals(username)) {
				return d;
			}
		}
		return null;
	}
	public Driver getDriverByPassword(String password)	{
		for (Driver d : drivers)	{
			if (d.getPassword().equals(password))	{
				return d;
			}
		}
		return null;
	}
	
	
	
	public Vehicle getVehicleByRegNo(String regNo)	{
		for (Vehicle v : vehicles)	{
			if (v.getRegNo().equals(regNo)) {
				return v;
			}
		}
		return null;
	}
	

	
	public void SetupWorkSchedule()	{
		
	}
}
