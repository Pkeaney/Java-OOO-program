package coursework;

public class Tanker extends Vehicle {
	private int liquidCapacity;
	private String liquidType;
	
	public Tanker(String make, String model, int weight, String regNo, 
				int liquidCapacity, String liquidType)	{
		
		super(make, model, weight, regNo);
		this.liquidCapacity = liquidCapacity;
		this.liquidType = liquidType;
	}
	
	@Override
	public String toString()	{
		
		return this.getClass().getSimpleName() + " >> " +
				"Tanker Make: " + make + " " +
				"Tanker Model: " + model + " " + 
				"Registration Number: " + regNo + " " +
				"Weight: " + weight		+ " " +
				"Liquid Capacity: " + liquidCapacity + " " +
				"Liquid Type: " + liquidType;
	}
}
