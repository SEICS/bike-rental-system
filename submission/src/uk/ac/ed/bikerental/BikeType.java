package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BikeType {
	private String type;
	private BigDecimal oriReplacementValue;
	private BigDecimal newReplacementValue = this.oriReplacementValue;
	private BigDecimal dailyRentalPrice = new BigDecimal("0.0");
	
	public BikeType(String type, BigDecimal oriReplacementValue, BigDecimal newReplacementValue,
			BigDecimal dailyRentalPrice) {
		this.type = type;
		this.oriReplacementValue = oriReplacementValue;
		this.newReplacementValue = newReplacementValue;
		this.dailyRentalPrice = dailyRentalPrice;
	}

	public void setType(String bikeType) {
		this.type = bikeType;
	}
	
	public void setReplacementValueAtStart(BigDecimal value){
		this.oriReplacementValue = value;
	}
	
	public void setNewReplacementValue(BigDecimal value){
		this.newReplacementValue = value;
	}
	
	public void setDailyRentalPrice(BigDecimal price){
		this.dailyRentalPrice = price;
	}
	
	public String getType(){
		return this.type;
	}
	
    public BigDecimal getOriReplacementValue(){
        return this.oriReplacementValue;
    }
    
    public BigDecimal getNewReplacementValue(){
        // TODO: Implement Bike.getReplacementValue
        //assert false;
        return this.newReplacementValue;
    }
    
    public BigDecimal getDailyRentalPrice(){
		return this.dailyRentalPrice;
	}
    
    public String getBikeTypeInfo(){
    	String bikeType = this.type + "\n";
    	String replacement = "Bike replacement value: " + String.valueOf(this.newReplacementValue) + "\n";
    	String dailyPrice = "Bike daily rental price: " + String.valueOf(this.dailyRentalPrice) + "\n";
    	String bikeTypeInfo = bikeType + replacement + dailyPrice;
    	return bikeTypeInfo;
    }
}