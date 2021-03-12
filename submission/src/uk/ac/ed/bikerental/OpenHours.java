package uk.ac.ed.bikerental;

public class OpenHours {
	private String openTime;
	private String closeTime;
		
	public OpenHours(String openTime, String closeTime) {
		this.openTime = openTime;
		this.closeTime = closeTime;
	}

	public void setOpenTime(Integer hours, Integer minutes){
		this.openTime = hours.toString() + ":" + minutes.toString();
	}
	
	public void setCloseTime(Integer hours, Integer minutes){
		this.closeTime = hours.toString() + ":" + minutes.toString();
	}
	
	public String getOpenTime(){
		return this.openTime;
	}
	
	public String getCloseTime(){
		return this.closeTime;
	}	
}
