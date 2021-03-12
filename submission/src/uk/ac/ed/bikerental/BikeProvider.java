package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class BikeProvider implements ValuationPolicy {
	private BikeShop shop;
	private ArrayList<Quotes> quoteList = new ArrayList<Quotes>();
	private ArrayList<Bike> bikeList = new ArrayList<Bike>();
	private HashMap<BikeShop, BikeShop> partnerList = new HashMap<BikeShop, BikeShop>();
	
	public BikeProvider(BikeShop shop, ArrayList<Quotes> quoteList, ArrayList<Bike> bikeList) {
		super();
		this.shop = shop;
		this.quoteList = quoteList;
		this.bikeList = bikeList;
	}

	public void registerShop(BikeShop shopA){
		this.shop = shopA;
	}
	
	public void addQuote(Quotes newQuote){
		this.quoteList.add(newQuote);
	}
	
	public void addToBikeList(Bike newBike){
		this.bikeList.add(newBike);
	}
	
	public void addPartner(BikeShop shopB){
		partnerList.put(this.shop, shopB);
	}
	
	public void deleteFromQuoteList(Quotes quote){
		if (this.quoteList.isEmpty()){
			System.out.println("The list is empty! Nothing can be deleted.");
		}
		this.bikeList.remove(quote);
	}
	
	public void deleteFromBikeList(Bike Bike){
		if (this.bikeList.isEmpty()){
			System.out.println("The list is empty! Nothing can be deleted.");
		}
		this.bikeList.remove(Bike);
	}
	
	public void deletePartner(BikeShop shopB){
		partnerList.remove(this.shop, shopB);
	}
	
	public BikeShop getProviderShop(){
		return this.shop;
	}
	
	public ArrayList<Quotes> sendQuotes(){
		return this.quoteList;
	}
	
	public ArrayList<Bike> getBikeList(){
		return this.bikeList;
	}
	
	public HashMap<BikeShop, BikeShop> getPartnerList(){
		return this.partnerList;
	}

	@Override
	public BigDecimal calculateValue(Bike bike, LocalDate date) {
		return bike.calculateDeposit();
	}
}
