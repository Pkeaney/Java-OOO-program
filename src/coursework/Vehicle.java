package coursework;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import coursework.WorkSchedule;

public abstract class Vehicle implements Serializable{
	protected String make;
	protected String model;
	protected int weight;
	protected String regNo;
	protected String weightStr = String.valueOf(weight);
	
	private WorkSchedule workSchedule;
	
	protected List<WorkSchedule> workschedules = new ArrayList<WorkSchedule>();

	public Vehicle(String make, String model, int weight, String regNo)	{
		this.make = make;
		this.model = model;
		this.weight = weight;
		this.regNo = regNo;
	}
	
	public String getMake()	{
		return make;
	}
	
	public String getModel()	{
		return model;
	}
	
	public int getWeight()	{
		return weight;
	}
	
	public String getRegNo()	{
		return regNo;
	}
	
	public void makeSchedule(WorkSchedule getStartTime)	{
		workschedules.add(getStartTime);
	}
	
	public Boolean IsAvailable()	{
		return null;
}
	
	
	public WorkSchedule getNextSchedule()	{
		workschedules.sort(Comparator.comparing(o -> o.getStartDate()));
		
		return workschedules.stream().filter(o -> o.getStartDate().isAfter(LocalDateTime.now())).findFirst().get();
	}
	
}
