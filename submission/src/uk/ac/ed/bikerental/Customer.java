package uk.ac.ed.bikerental;

import java.util.ArrayList;
import java.util.Random;

public class Customer {
	private RentalNeeds requirement;
	private String customerID;
	private Location homeLocation;
	
	public Customer(RentalNeeds requirement, Location homeLocation) {
		this.requirement = requirement;
		this.customerID = customerID;
		this.homeLocation = homeLocation;
	}

	public void setRequirement(RentalNeeds need){
		this.requirement = need;
	}
	
	public void generateCustomerID(){
		Random random = new Random();
		int ID = random.nextInt();
		if (ID>0){
			this.customerID = Integer.toString(ID);
		}
	}
	
	public void setHomeLocation(Location home){
		this.homeLocation = home;
	}
	
	public RentalNeeds getRentalNeeds(){
		return this.requirement;
	}
	
	public String getCustomerID(){
		return this.customerID;
	}
	
	public Location getHomeLocation(){
		return this.homeLocation;
	}

	public String getCustomerInfo(){
		String ID = "Customer ID: " + this.customerID + "\n";
		//Address:
		String customerAddr = "Customer address: " + homeLocation.getAddress() + "\n";
		//Postcode:
		String customerPstC = "Customer postcode: " + homeLocation.getPostcode() + "\n";
		String customerInfo = ID + customerAddr + customerPstC; 
		return customerInfo;
	}
}
