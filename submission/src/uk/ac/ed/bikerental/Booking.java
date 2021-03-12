package uk.ac.ed.bikerental;

import java.math.BigDecimal;

public class Booking {
	private Customer customer;
	private Driver driver;
	private Quotes quote;
	private BigDecimal payment = new BigDecimal("0.0");
	private Boolean paymentSuccess = false;
	private String orderID;
	private String pickMode;
	
	public Booking(Customer customer, Driver driver, Quotes quote,
			String orderID, String pickMode) {
		this.customer = customer;
		this.driver = driver;
		this.quote = quote;
		this.payment = payment;
		this.paymentSuccess = paymentSuccess;
		this.orderID = orderID;
		this.pickMode = pickMode;
	}

	public void setBooking(Quotes quoteA){
		this.quote = quoteA;
	}
	
	public void setCustomer(Customer customerA){
		this.customer = customerA;
	}
	
	public void setDriver(Driver driverA){
		this.driver = driverA;
	}
	
	public void setOrderID(){
		this.orderID = quote.getQuoteID();	
	}
	
	public void setPickUpMode(String mode){
		this.pickMode = mode;
	}
	
	public String getOrderID(){
		return this.orderID;
	}
	
	public String getPickMode(){
		return this.pickMode;
	}
	
	public Customer customerOfBooking(){
		return this.customer;
	}
	
	public Driver driverOfBooking(){
		return this.driver;
	}
	
	public void payForBooking(BigDecimal moneyForPay){
		this.payment = moneyForPay;
		this.paymentSuccess = true;
	}
	
	public Boolean checkPaySuccess(){
		return paymentSuccess;
	}
	
	public String getBookingInfo(){
		String ID = "Order ID: " + this.orderID + "\n";
		String shopAndBikeInfo = this.quote.getShopAndBikeInfo();
		String customerInfo = customer.getCustomerInfo();
		String bookingInfo = "\nBooking details: " + "\n" + ID + shopAndBikeInfo + customerInfo;
		return bookingInfo;
	}
}
