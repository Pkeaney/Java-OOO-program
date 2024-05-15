package Main;
import java.util.*;

import coursework.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sys {
	private final String PATH = "D:\\data\\";
	private final Scanner input = new Scanner(System.in);
	private List<Depot> depots = new ArrayList<Depot>();
	private Depot depot;
	private Driver driver;
	private Manager manager;
	// Array list for depots?
	//private Surgery surgery?!?!?
	
	
	public Sys()	{
deSerialize();
		//DEBUGGING - used to create the depots.ser file
//		depots.add(new Depot("Liverpool"));
//		depots.add(new Depot("Manchester"));
//		depots.add(new Depot("Leeds"));
//		
//		
//		Vehicle v1 = new Truck("Ford", "F450", 44, "1001", 40);
//		depots.get(0).makeVehicle(v1);
//		Vehicle v2 = new Tanker("Saab", "S230", 44, "1002", 100, "Oil");
//		depots.get(0).makeVehicle(v2);
//		
//		Driver d1 = new Driver("Lauren", "_Lauren");
//		depots.get(0).makeDriver(d1);
//		
//		Driver d2 = new Driver("Patrick", "_Patrick");
//		depots.get(0).makeDriver(d2);
//		
//		WorkSchedule schedule1 = new WorkSchedule("Liverpool", "Lauren", v1, LocalDateTime.of(2020, 5, 02, 9, 00), LocalDateTime.of(2020, 05, 02, 16, 30));
//		depots.get(0).makeSchedule(schedule1);
//		
//		WorkSchedule schedule2 = new WorkSchedule("Liverpool", "Patrick", v2, LocalDateTime.of(2020, 5, 04, 12, 00), LocalDateTime.of(2020, 05, 04, 21, 00));
//		depots.get(0).makeSchedule(schedule2);
	}
	
	public void entryMenu()	{
	//Going to be the main menu of the system
		
		String choice = "";
		
		do {
			System.out.println("----MAIN MENU----");
			System.out.println("Please choose what you would like to do:");
			System.out.println("1. Log In as Manager");
			System.out.println("2. -");
			System.out.println("Q. Quit System");
			
			choice = input.nextLine().toUpperCase();
			
			switch (choice)	{
			case "1"	: 	{
				logOn();
				break;
			}
			case "2"	:
				readYaBoi();
				break;
			
			}	
}	while (!choice.equals("Q"));

		serialize();
		
System.out.println("You are now Quitting the System");


}

	private void deSerialize()	{
		ObjectInputStream ois;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(PATH + "depots.ser"));
			
			depots = (List<Depot>)ois.readObject();
			
			ois.close();
		}
		catch (Exception e)	{
			System.out.println(e.getMessage());
		}
	}
	
	private void serialize()	{
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(PATH + "depots.ser"));
			oos.writeObject(depots);
			
			oos.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void logOn()	{
		printDepots();
		System.out.println("\n What depot are you logging into? \n");
		String location = input.nextLine();
		
		System.out.println("What is your username? \n");
		String username = input.nextLine();
		
		System.out.println("What is your password? \n");
		String pass = input.nextLine();
		
		depot = findDepotByName(location);
		if (depot != null)	{
			
			driver = depot.getDriverByName(username);
			if(driver != null)	{
				if(driver.checkPassword(pass)) {
					if(Manager.class.isInstance(driver))	{
						manager = Manager.class.cast(driver);
						depotMenu();
					} else {
						driverMenu();
					}
				} else {System.out.print("Password wrong");
				}
		}
		 
		}
			System.out.print("BYE BYE!!!");
	}
			
		
		
		//NEED TO MAKE REAL LOGIN
	//	depot = depots.get(0);

	private void readYaBoi()	{
		depotMenu();
	}
	
	public void driverMenu()	{
		System.out.print("Driver Menu");
	}
	
	public void depotMenu()	{
		String choice = "";
		
		do { 
			System.out.println("---- DEPOT MENU----");
			System.out.println("1. addVehicle");
			System.out.println("2. addDriver");
			System.out.println("3. makeSchedule");
			System.out.println("4. SearchVehicle");
			System.out.println("5. SearchDriver");
			System.out.println("Q. Quit");
			
			choice = input.nextLine().toUpperCase();
			
			switch (choice) {
			case "1" : {
				addVehicle();
				break;
			}
			case "2" : {
				addDriver();
				break;
			}
			case "3" : {
				addWorkSchedule();
				break;
			}
			case "4" : {
				getVehicleByRegNo();
			}
			case "5" : {
				getDriverByName();
			}
			}
		} while (!choice.equals("Q"));
		
		depot = null;
	}
	
	
	
	
	
	public void getDepotByName()	{
		System.out.print("Depot Name: ");
		String name = input.nextLine();

		findDepotByName(name);
	}
	
	public Depot findDepotByName(String name)	{
		for (Depot d : depots)	{
			if(d.getDepotName().equals(name))	{
				return d;
			}
		} return null;
	}
	
	//Method to add a Vehicle to the system, simply Asks for Name and Password.
	private void addVehicle()	{
	String choice = "";
		System.out.println("What type of Vehicle would you like to add?");
		System.out.println("1. Truck");
		System.out.println("2. Tanker");
		choice = input.nextLine();
		
		switch (choice) {
		case "1" : {
			addTruck();		
			break;
		}						//User selects 1 if they want to add a truck, 2 if they 
								//want to add a Tanker
		case "2" : {
			addTanker();
			break;
		}
	}
	
	}
	
	private void addTruck()	{				
		System.out.print("Vehicle make: ");
		String make = input.nextLine();
		System.out.print("Vehicle model: ");
		String model = input.nextLine();
		System.out.print("Vehicle regNo: ");
		String regNo = input.nextLine();
		System.out.print("Vehicle weight: ");
		int weight = input.nextInt();
		System.out.print("Cargo Capacity: ");
		int cargocapacity = input.nextInt();
		depot.makeVehicle(new Truck(make, model, weight, regNo, cargocapacity));
		
	}
	
	private void addTanker()	{
		System.out.print("Vehicle make(Saab): \n");
		String make = input.nextLine();
		System.out.print("Vehicle model(e.g. S450): \n");
		String model = input.nextLine();
		System.out.print("Vehicle regNo(e.g. 1A21): \n");
		String regNo = input.nextLine();
		System.out.print("Vehicle weight(Tonnes): \n");
		int weight = input.nextInt();
		System.out.print("Liquid Capacity(Litre): \n");
		int liquidcapacity = input.nextInt();
		System.out.print("Liquid Type: \n");
		String liquidType = input.next();
		depot.makeVehicle(new Tanker(make, model, weight, regNo, liquidcapacity, liquidType));
	
	}
	private void addDriver()	{
		System.out.print("Driver name: ");
		String name = input.nextLine();
		System.out.print("Driver Password: ");
		String password = input.nextLine();
		
		depot.makeDriver(new Driver(name, password));
	}
	
	private void addWorkSchedule()	{
		System.out.print("Depot's Name: ");
		String depotName = input.nextLine();
		System.out.print("Drivers Name: ");
		String name = input.nextLine();
		System.out.print("Vehicles Registration no.: ");
		String regNo = input.nextLine();
		Vehicle vehicle = depot.getVehicleByRegNo(regNo);
		System.out.print("Schedule Start Time: ");
		LocalDateTime startTime = LocalDateTime.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd MMM yy HH:mm"));
		System.out.print("Schedule End Time: ");
		LocalDateTime endTime = LocalDateTime.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd MMM yy HH:mm"));
		
		depot.makeSchedule(new WorkSchedule(depotName, name, vehicle, startTime, endTime));
	}
	
	private void getVehicleByRegNo()	{
		System.out.println("Please enter the Registration Number of the Vehicle: ");
		String regNo = input.nextLine();
		
		System.out.println(depot.getVehicleByRegNo(regNo).toString());
	}
	
	private void getDriverByName()	{
		System.out.println("Please enter the Name of the Driver: ");
		String username = input.nextLine();
		
		System.out.println(depot.getDriverByName(username).toString());
	}

	private void printDepots()	{
		System.out.print(depots.toString());
	}
	
	}