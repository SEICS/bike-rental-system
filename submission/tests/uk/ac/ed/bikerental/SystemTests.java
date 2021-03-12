package uk.ac.ed.bikerental;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class SystemTests {
    // You can add attributes here
	private DateRange dateRange1, dateRange2,dateRange3;
	private Bike b1,b2;
	private BikeType btype1, btype2;
	private BikeProvider pro1, pro2;
	private BikeShop bikeshop1,bikeshop2;
	private Quotes q1,q2,q3;
	private Location l1,l2,l3;
	private Customer customer;
	private RentalNeeds need;
	private ArrayList<Quotes> result, quoteList1, quoteList2;
	private Controller controller;
	private Booking book;
	private OpenHours openHours1, openHours2;
	private Driver driver;

    @BeforeEach
    void setUp() throws Exception {
        // Setup mock delivery service before each tests
        DeliveryServiceFactory.setupMockDeliveryService();
        
        // Put your test setup here
        
        //set up open hours
        this.openHours1 = new OpenHours("10.00","18.00");
        this.openHours2 = new OpenHours("09.30","19.00");
        
        //setup dateRange
        this.dateRange1 = new DateRange(LocalDate.of(2019, 1, 7),
                LocalDate.of(2019, 1, 10));
        this.dateRange2 = new DateRange(LocalDate.of(2019, 1, 5),
                LocalDate.of(2019, 1, 23));
        this.dateRange3 = new DateRange(LocalDate.of(2015, 1, 7),
                LocalDate.of(2018, 1, 10));
        
        //set up location
        this.l1 = new Location("333 332", "GS");
    	this.l2 = new Location("333 333", "AH");
    	this.l3 = new Location("111 111", "SS");
        
        //set up bike type with their own replacement value
        BigDecimal reValue1 = new BigDecimal(800);
        BigDecimal newReValue1 = new BigDecimal(630);
        BigDecimal  dailyRP1 = new BigDecimal(5);
        this.btype1 = new BikeType("Mountain",reValue1,newReValue1,dailyRP1);
        
        BigDecimal reValue2 = new BigDecimal(600);
        BigDecimal newReValue2 = new BigDecimal(380);
        BigDecimal dailyRP2 = new BigDecimal(4);
        this.btype2 = new BikeType("Road", reValue2,newReValue2,dailyRP2);
        
        //set up shops
        this.bikeshop1 = new BikeShop("HAA Shop", l1, openHours1);
        this.bikeshop1.generateShopID();
        this.bikeshop2 = new BikeShop("NNN Shop", l3, openHours2);
        this.bikeshop2.generateShopID();
       
        //set up bike
        BigDecimal bikeAge1 = new BigDecimal(2);
        BigDecimal depositR1 = new BigDecimal(0.1);
        BigDecimal deposit1 = new BigDecimal(100);
        this.b1 = new Bike(btype1, bikeAge1, bikeshop1.getShopID(), "123456", depositR1, 1,
        		deposit1, "In stock");
        
        BigDecimal bikeAge2 = new BigDecimal(3);
        BigDecimal depositR2 = new BigDecimal(0.15);
        BigDecimal deposit2 = new BigDecimal(100);
        this.b2 = new Bike(btype2, bikeAge2, bikeshop2.getShopID(), "123457", depositR2, 1,
        		deposit2, "In stock");
        
        ArrayList<Bike> bikeList1 = new ArrayList<Bike> ();
        bikeList1.add(b1);
        
        ArrayList<Bike> bikeList2 = new ArrayList<Bike> ();
        bikeList2.add(b2);
        
        //set up rental needs
        this.need = new RentalNeeds(1, btype1, dateRange1, l2);
   
        
        //set up customer information and their rental needs
        this.customer = new Customer(need, l2);
        this.customer.generateCustomerID();

        BigDecimal price1 = new BigDecimal(10);
        this.q1 = new Quotes(b1, bikeshop1, price1);
        
        BigDecimal price2 = new BigDecimal(8);
        this.q2 = new Quotes(b2, bikeshop2, price2);

        
        this.result = new ArrayList<Quotes>();
        this.result.add(q1);
        this.result.add(q2);
        
        this.quoteList1 = new ArrayList<Quotes> ();
        this.quoteList1.add(q1);
        this.quoteList2 = new ArrayList<Quotes> ();
        this.quoteList2.add(q2);
        
      //set up providers
        ArrayList<BikeProvider> providerList = new ArrayList<BikeProvider> ();
        this.pro1 = new BikeProvider(bikeshop1,quoteList1, bikeList1);
        providerList.add(pro1);
        this.pro2 = new BikeProvider(bikeshop2,quoteList2, bikeList2);
        providerList.add(pro2);
        
        //System.out.println(quoteList1);
        //System.out.println("-------");
        //System.out.println(this.pro1.sendQuotes());
        
        pro1.addPartner(bikeshop2);
        HashMap<BikeShop, BikeShop> partnerList = new HashMap<BikeShop, BikeShop> ();
        
        this.driver = new Driver("SQ", "A3777");
        
        book = new Booking(customer, driver, q1, q1.getQuoteID(), "collectInStore");
        ArrayList<Booking> bookingList = new ArrayList<Booking> ();
        
        controller = new Controller(providerList, result, bookingList);
    }
    
    // TODO: Write system tests covering the three main use cases
   
    @Test
    void TestFilterQuote() {
    	 
         this.result = controller.filterQuote(customer);
         System.out.println(result);
         System.out.println(quoteList1);
         assertEquals(result,quoteList1);

    }
 
    @Test
    void TestBookQuote() {
    	 int k = controller.bookMultiQuote(customer, q1, quoteList1).size();
    	 assertTrue(k>=0);
    }
    
    //Test for returning to original or partner
    @Test
    void TestReturnToProvider() {
    	for(int i=0; i<quoteList1.size(); i++) {
    		q3 = quoteList1.get(i);
    		
    		assertTrue(q3.getQuoteBike().getState() == "In stock");
    			
    		
    	}
    }
    
}
