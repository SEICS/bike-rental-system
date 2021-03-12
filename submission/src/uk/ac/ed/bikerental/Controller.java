package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class Controller {
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Driver> driverList = new ArrayList<Driver>();
	private ArrayList<BikeProvider> bikeProviderList = new ArrayList<BikeProvider>();
	private ArrayList<Quotes> availableQuoteList = new ArrayList<Quotes>();
	private ArrayList<Booking> bookingList = new ArrayList<Booking>();
	private DeliveryServiceFactory deliveryCompany;
	private String waitMessage = "";
	private Boolean hasQuote = false;
	
	public Controller(ArrayList<BikeProvider> bikeProviderList, ArrayList<Quotes> availableQuoteList,
			ArrayList<Booking> bookingList) {
		this.customerList = customerList;
		this.driverList = driverList;
		this.bikeProviderList = bikeProviderList;
		this.availableQuoteList = availableQuoteList;
		this.bookingList = bookingList;
		this.waitMessage = waitMessage;
		this.hasQuote = hasQuote;
	}

	public void addCustomer(Customer customerA){
		customerList.add(customerA);
	}
	
	public void deleteCustomer(Customer customerA){
		customerList.remove(customerA);
	}
	
	public void addBikeProvider(BikeProvider bikeProviderA){
		bikeProviderList.add(bikeProviderA);
	}
	
	public void deleteBikeProvider(BikeProvider bikeProviderA){
		bikeProviderList.remove(bikeProviderA);
	}
	
	public ArrayList<Quotes> filterQuote(Customer customerA){
		ArrayList<Quotes> newQuoteList = new ArrayList<Quotes>();
		RentalNeeds need = customerA.getRentalNeeds();
		int i;
		int j;
		//goes for all bike providers on the system
		for (i = 0; i < bikeProviderList.size(); i++){
			BikeProvider bikeProvider = bikeProviderList.get(i);
			ArrayList<Quotes> quoteList = bikeProvider.sendQuotes();
			//goes for all possible quotes of a bike providers
			for (j = 0; j < quoteList.size(); j++){
				Bike bikeA = quoteList.get(j).getQuoteBike();
				//find the avaliable quote based on rental needs
				if (bikeA.getBikeType().getType().equals(need.getTypeOfBike().getType())){
					if (bikeA.getState().equals("In stock")){
						if (bikeProvider.getProviderShop().getShopLocation().isNearTo(need.getLocationOfHire())){
							newQuoteList.add(quoteList.get(j));
						}
					}
				}
			}
		}
		this.availableQuoteList = newQuoteList;
		return this.availableQuoteList;
	}
	
	public ArrayList<Quotes> findQuotesFromSameProvider(ArrayList<Quotes> list, Quotes quoteA){
		ArrayList<Quotes> sameProviderQuoteList = new ArrayList<Quotes>();
		int q;
		//find all quotes from same provider
		for (q = 0; q < list.size(); q++){
			Quotes quoteB = list.get(q);
			if (quoteB.equals(quoteA)){
				sameProviderQuoteList.add(quoteB);
			}
		}
		return sameProviderQuoteList;
	}
	
	public Boolean checkIfThereIsAQuote(){
		if (!this.availableQuoteList.isEmpty()){
			this.hasQuote = true;
		}
		return this.hasQuote;
	}
	
	public void waitMessage(){
		if (this.hasQuote){
			this.waitMessage = "Sorry for no available quote right now, please wait for some time!";
			System.out.println(this.waitMessage);
		}
	}
	
	public void registerDriver(Driver driverA){
		this.driverList.add(driverA);
	}
	
	private static int getRandomNumberInRange(int min, int max){
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public ArrayList<Booking> bookSingleQuote(Customer customerA, Quotes quoteA){
		Booking bookingA = null;
		ArrayList<Booking> bookingListA = new ArrayList<Booking>();
		bookingA.setBooking(quoteA);
		bookingA.setCustomer(customerA);
		int index = getRandomNumberInRange(0,driverList.size());
		bookingA.setDriver(driverList.get(index));
		bookingListA.add(bookingA);
		this.bookingList = bookingListA;
		return this.bookingList;
	}
	
	public ArrayList<Booking> bookMultiQuote(Customer customerA, Quotes quoteA, ArrayList<Quotes> list){
		int k;
		ArrayList<Booking> bookingListA = new ArrayList<Booking>();
		ArrayList<Quotes> newlist = findQuotesFromSameProvider(list, quoteA);
		//find all quotes from same provider
		for (k = 1; k < list.size(); k++){
			Booking bookingA = null;
			bookingA.setBooking(list.get(k));
			bookingA.setCustomer(customerA);
			int index = getRandomNumberInRange(0,driverList.size());
			bookingA.setDriver(driverList.get(index));
			bookingListA.add(bookingA);
			this.bookingList = bookingListA;
		}
		return this.bookingList;
	}
	
	public String sendConfirmation(){
		Confirmation confirmation = null;
		confirmation.setBookingList(this.bookingList);
		return confirmation.generateConfirmation();
	}
	
	public DeliveryService deliveryBike(){
		if (!this.driverList.isEmpty()){
			this.deliveryCompany.setupMockDeliveryService(); 
		}
		return this.deliveryCompany.getDeliveryService();
	}
	
	public Boolean returnBike(String personID, BikeShop bikeShopA, Bike bikeA){
		Bike returnBike = bikeA;
		if (bikeA.getShopID().equals(bikeShopA.getShopID())){
			returnBike.setState("In stock");
			return true;
		}else{
			return false;	
		}
	}
	
	public String interruptPayment(Booking bookingA){
		if (bookingA.checkPaySuccess() == false){
			return "Payment unsuccessful! Go back to previous section.";
		}
		return null;
	}
}
