package uk.ac.ed.bikerental;

import java.util.ArrayList;

public class Confirmation {
	private ArrayList<Booking> bookingList = new ArrayList<Booking>();
    private ArrayList<String> confirmationDetails = new ArrayList<String>();
    
    public Confirmation(ArrayList<Booking> bookingList, ArrayList<String> confirmationDetails) {
		this.bookingList = bookingList;
		this.confirmationDetails = confirmationDetails;
	}

	public void setBookingList(ArrayList<Booking> list){
    	this.bookingList = list;
    }
	
	public String generateConfirmation(){
		int i;
		for (i = 0; i < this.bookingList.size(); i++){
			Booking booking = bookingList.get(i);
			confirmationDetails.add(booking.getBookingInfo());
		}
		return ("Booking successfully set!\nBooking details: \n" + confirmationDetails.toString());
	}	
}
