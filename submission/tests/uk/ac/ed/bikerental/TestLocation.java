package uk.ac.ed.bikerental;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TestLocation {
	
	private Location location1, location2, location3;
	
    @BeforeEach
    void setUp() throws Exception {
        // TODO: setup some resources before each test
    	this.location1 = new Location("333 332", "GS");
    	this.location2 = new Location("333 333", "AH");
    	this.location3 = new Location("111 111", "SS");
    }
    
    // TODO: put some tests here
    
    @Test
    void testIsNearToTrue() {
    	assertTrue(location1.isNearTo(location2));
    }
    
    void testIsNearToFalse() {
    	assertFalse(location2.isNearTo(location3));
    }
}
