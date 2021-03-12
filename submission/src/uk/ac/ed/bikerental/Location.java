package uk.ac.ed.bikerental;

public class Location {
    private String postcode;
    private String address;
    
    /*@param postcode          - the postcode of a location
      @param address           - the address of a location*/
    public Location(String postcode, String address) {
		this.postcode = postcode;
		this.address = address;
	}

    /*@param postcodeA         - the postcode of a location
      @param addressA          - the address of a location*/
	public void setLocation(String postcodeA, String addressA) {
        assert postcode.length() >= 6;
        this.postcode = postcodeA;
        this.address = addressA;
    }
    
	/*@param other             - a location instance to compare if one location is nearby */
	/*@return */
    public boolean isNearTo(Location other) {
        // TODO: Implement Location.isNearTo
    	char[] otherPostcode = other.postcode.toCharArray(); 
    	char[] thisPostcode = this.postcode.toCharArray();
    	int exit = 0;
    	int i = 0;
    	
    	while ((exit != 1) && (i < 3)){
    		if (otherPostcode[i] != thisPostcode[i]){
    			exit = 1;
    		}
    		i++;
    	}
    	
    	if (exit == 0){
    		return true;
    	}else{
    		return false;
    	}

        //assert false;
        //return null;
    }

    /*@return */
    public String getPostcode() {
        return postcode;
    }

    /*@return */
    public String getAddress() {
        return address;
    }
    
    // You can add your own methods here
    /*@return */
    public String getLocationInfo(){
    	String Addr = "Address: " + this.address + "\n";
    	String Postcode = "Postcode: " + this.postcode + "\n";
    	String locationInfo = Addr + Postcode;
    	return locationInfo;
    }
}
