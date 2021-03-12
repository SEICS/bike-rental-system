package uk.ac.ed.bikerental;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.io.Console;
import java.math.BigDecimal;

public class Bike {
	private BigDecimal bikeAge = new BigDecimal("0.0");
	private String shopID = "";
	private String bikeID = "";
	private BigDecimal depositRate = new BigDecimal("0.0");
	private Integer numInStock = 0;
	private BigDecimal deposit = new BigDecimal("0.0");
	private String state = "In stock";
	private BikeType thisType;
	BigDecimal one = new BigDecimal("1.0");

	public Bike(BikeType thisType, BigDecimal bikeAge, String shopID, String bikeID, BigDecimal depositRate,
			Integer numInStock, BigDecimal deposit, String state) {
		this.thisType = thisType;
		this.bikeAge = bikeAge;
		this.shopID = shopID;
		this.bikeID = bikeID;
		this.depositRate = depositRate;
		this.numInStock = numInStock;
		this.deposit = deposit;
		this.state = state;
	}

	public void setType(BikeType bikeType){
		this.thisType = bikeType;
	}
	
	public void setShopID(String shopID){
		this.shopID = shopID;
	}
	
	public void setBikeID(String bikeID){
		this.bikeID = bikeID;
	}
	
	public void setBikeAge(BigDecimal usedTime){
		this.bikeAge = usedTime;
	}
	
	public void setDepositRate(BigDecimal rate){
		this.depositRate = rate;
	}
	
	//deposit = replacementValue * (1-depositRate)
	
	public BigDecimal calculateDeposit(){
		this.deposit = (thisType.getNewReplacementValue()).multiply(one.subtract(this.depositRate));
		return this.deposit;
	}
	
	public void setNumInStock(Integer numOfBike){
		this.numInStock = numOfBike;
	}
	
	public void setState(String bikeState){
		this.state = bikeState;
	}
	
    @Override
	public String toString() {
		return "Bike [bikeAge=" + bikeAge + ", shopID=" + shopID + ", bikeID=" + bikeID + ", depositRate=" + depositRate
				+ ", numInStock=" + numInStock + ", deposit=" + deposit + ", state=" + state + ", thisType=" + thisType
				+ ", one=" + one + "]";
	}

	public BikeType getBikeType() {
        // TODO: Implement Bike.getType
        //assert false;
        return this.thisType;
    }
    
    public String getBikeID(){
		return this.bikeID;
	}
    
    public String getShopID(){
		return this.shopID;
	}
    
    public BigDecimal getBikeAge(){
    	return this.bikeAge;
    }
    
    public BigDecimal getDeposit(){
		return this.deposit;
	}
    
    public Integer getNumInStock(){
		return this.numInStock;
	}
    
    public String getState(){
		return this.state;
	}
    
    public String getBikeInfo(){
    	String ID = "Bike ID: " + this.bikeID + "\n";
    	String Biketype = "Bike type: " + this.thisType.getType() + "\n";
		String deposit = "Bike deposit: " + String.valueOf(this.deposit) + "\n";
		String BikeInfo = ID + Biketype + deposit;
		return BikeInfo;
    }
}