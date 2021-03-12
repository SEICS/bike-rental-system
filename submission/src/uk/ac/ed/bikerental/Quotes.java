package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.Random;

public class Quotes {
	private String quoteID = "";
	private Bike bike;
	private String bike_info = "";
	private BikeShop shop;
	private BigDecimal price = new BigDecimal("0.0");
	
	public Quotes( Bike bike, BikeShop shop, BigDecimal price) {
		this.quoteID = quoteID;
		this.bike = bike;
		this.bike_info = bike_info;
		this.shop = shop;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Quotes [quoteID=" + quoteID + ", bike=" + bike + ", bike_info=" + bike_info + ", shop=" + shop
				+ ", price=" + price + "]";
	}

	public void generateQuoteID(){
		Random random = new Random();
		int ID = random.nextInt();
		if (ID>0){
			this.quoteID = Integer.toString(ID);
		}
	}
	
	public String getQuoteID(){
		return quoteID;
	}
	
	public Bike getQuoteBike(){
		return this.bike;
	}
	
	public String getShopAndBikeInfo(){
		String shopInfo = this.shop.getBikeShopInfo();
		String bikeInfo = this.bike.getBikeInfo();
		String info = shopInfo + bikeInfo;
		return info;
	}
	
	public String getQuote(){
		String ID = "Quote ID: " + this.quoteID + "\n";
		String shopInfo = this.shop.getBikeShopInfo();
		String bikeInfo = this.bike.getBikeInfo();
		String Quoteinfo = ID + shopInfo + bikeInfo;
		return Quoteinfo;
	}
	
}
