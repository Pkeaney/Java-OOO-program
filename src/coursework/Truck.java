package coursework;

public class Truck extends Vehicle {

	private int cargoCapacity;
	
	public Truck(String make, String model, int weight, String regNo, 
			int cargoCapacity)	{
		
		super(make, model, weight, regNo);
		this.cargoCapacity = cargoCapacity;
		
	}
	
	@Override
	public String toString()	{
		
		
		return this.getClass().getSimpleName() + " >> " +
				"Truck Make: " + make + " " +
				"Truck Model: " + model + " " +
				"Registration Number: " + regNo + " " +
				"Weight: " + weight + " " +
				"Cargo Capacity: " + cargoCapacity;
	}
	
}
