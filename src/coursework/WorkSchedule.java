package coursework;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.format.*;


public class WorkSchedule implements Serializable {
	private String depotName;
	private String name;
	private Vehicle vehicle;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
public WorkSchedule(String depotName, String name, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate) {
		this.depotName = depotName;
		this.name = name;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	@Override
	
	public String toString()	{
		return this.getClass().getSimpleName() + " >> " +
				depotName + " " +
				name + " " +
				vehicle + " " +
				startDate.format(DateTimeFormatter.ofPattern("dd MMM yy HH:mm")) + " " +
				endDate.format(DateTimeFormatter.ofPattern("dd MMM yy HH:mm"));
	}
	
	
	public String getDepot()	{
		return depotName;
	}
	
	public LocalDateTime getStartDate()	{
		return startDate;
	}
	
	public Vehicle getVehicle()	{
		return vehicle;
	}
	
	public LocalDateTime getEndDate()	{
		return endDate;
	}
	

	

}

	
