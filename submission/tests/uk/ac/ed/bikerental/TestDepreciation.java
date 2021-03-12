package uk.ac.ed.bikerental;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDepreciation {
	private Bike b1;
	private BikeType btype1;
	private Depreciation dp;
	private BigDecimal depreRate = new BigDecimal("0.1");
	private BikeShop bikeshop1;
	private OpenHours openHours1;
	private Location l1;
	private BigDecimal reValue1, newReValue1, newReValue2, dailyRP1;
	private BigDecimal depositR1,deposit1;


	@BeforeEach
	void setUp() throws Exception {
		
		//set up bike type with their own replacement value
		newReValue1 = new BigDecimal(0);
		reValue1 = new BigDecimal(900);
        this.btype1 = new BikeType("Mountain",reValue1,newReValue1,dailyRP1);
        //System.out.println(btype1.getOriReplacementValue());
        
        this.bikeshop1 = new BikeShop("HAA Shop", l1, openHours1);
       
        BigDecimal bikeAge1 = new BigDecimal(3);
        this.b1 = new Bike(this.btype1, bikeAge1, this.bikeshop1.getShopID(), "123456", depositR1, 1,
        		deposit1, "In stock");
        this.b1.getBikeAge();
        
        this.dp = new Depreciation(b1);
	}

	@Test
	void testLinearDepreciation() {
		BigDecimal p1 = new BigDecimal("630.0");	
		newReValue1 = this.dp.linearDepreciation(depreRate);
		System.out.println(newReValue1);
		assertEquals(p1, newReValue1);
	}
	
	@Test
	void testDoubleDecliningBalanceDepreciation() {
		BigDecimal p2 = new BigDecimal("460.800000");
		BigDecimal newReValue2 = this.dp.DoubleDecliningBalanceDepreciation(depreRate);
		assertEquals(p2, newReValue2);
	}

	

}