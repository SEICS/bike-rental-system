package uk.ac.ed.bikerental;

import java.util.Random;

public class BikeShop {
	@Override
	public String toString() {
		return "BikeShop [shopID=" + shopID + ", shopName=" + shopName + ", shopLocation=" + shopLocation
				+ ", openingHours=" + openingHours + "]";
	}

	private String shopID;
	private String shopName;
	private Location shopLocation;
	private OpenHours openingHours;
	
	public BikeShop(String shopName, Location shopLocation, OpenHours openingHours) {
		this.shopID = shopID;
		this.shopName = shopName;
		this.shopLocation = shopLocation;
		this.openingHours = openingHours;
	}

	public void generateShopID(){
		Random random = new Random();
		int ID = random.nextInt();
		if (ID>0){
			this.shopID = Integer.toString(ID);
		}
	}
	
	public void setShopName(String name){
		this.shopName = name;
	}
	
	public void setShopLocation(Location location){
		this.shopLocation = location;
	}
	
	public void setShopOpeningHours(OpenHours time){
		this.openingHours = time;
	}
	
	public String getShopID(){
		return shopID;
	}
	
	public String getShopName(){
		return this.shopName;
	}
	
	public Location getShopLocation(){
		return this.shopLocation;
	}
	
	public OpenHours getOpeningHours(){
		return this.openingHours;
	}
	
	public String getBikeShopInfo(){
		String infoID = "Shop ID: " + this.shopID + "\n";
		String infoName = "Shop name: " + this.shopName + "\n";
		String infoAddr = "Shop location: " + this.shopLocation + "\n";
		String infoOpenTime = "Shop opening time: " + this.openingHours.getOpenTime() +"-" + this.openingHours.getCloseTime() + "\n";
		String bikeShopInfo = infoID + infoName + infoAddr + infoOpenTime;
		return bikeShopInfo;
	}
}


