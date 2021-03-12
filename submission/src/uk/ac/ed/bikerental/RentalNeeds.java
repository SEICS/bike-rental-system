package uk.ac.ed.bikerental;

import java.time.LocalDate;

import java.time.LocalDate;

public class RentalNeeds {
	private Integer num_bike = 0;
	private BikeType type_bike;
	private DateRange date_range;
	private Location location_hire; 
	
	public RentalNeeds(Integer num_bike, BikeType type_bike, DateRange date_range, Location location_hire) {
		this.num_bike = num_bike;
		this.type_bike = type_bike;
		this.date_range = date_range;
		this.location_hire = location_hire;
	}

	public void setNumOfBike(Integer numOfBike){
		this.num_bike = numOfBike;
	}
	
	public void setTypeOfBike(BikeType typeOfBike){
		this.type_bike = typeOfBike;
	}
	
	public void setDateRange(DateRange dateRange){
		this.date_range = dateRange;
	}
	
	public void setLocationOfHire(Location location){
		this.location_hire = location;
	}
	
	public Integer getNumOfBike(){
		return this.num_bike;
	}
	
	public BikeType getTypeOfBike(){
		return this.type_bike;
	}
	
	public String getNameOfBikeType(){
		return this.type_bike.getType();
	}
	
	public DateRange getDateRange(){
		return this.date_range;
	}
	
	public Location getLocationOfHire(){
		return this.location_hire;
	}
}
