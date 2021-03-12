package uk.ac.ed.bikerental;

import java.util.Random;

public class Driver {
	private String driverID;
	private String driverName;
	private String carID;
	
	public Driver(String driverName, String carID) {
		this.driverID = driverID;
		this.driverName = driverName;
		this.carID = carID;
	}

	public void generateDriverID(){
		Random random = new Random();
		int ID = random.nextInt();
		if (ID>0){
			this.driverID = Integer.toString(ID);
		}
	}
	
	public void setDriverName(String name){
		this.driverName = name;
	}
	
	public void setCarID(String ID){
		this.carID = ID;
	}
	
	public String getDriverID(){
		return driverID;
	}
	
	public String getDriverName(){
		return this.driverName;
	}
	
	public String getCarID(){
		return this.carID;
	}
	
	public String getDriverInfo(){
		String info = "Driver " + this.driverName + " with driver ID " + this.driverID + " has car with car ID " + this.carID;
		return info;
	}
}
