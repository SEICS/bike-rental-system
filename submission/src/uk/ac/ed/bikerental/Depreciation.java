package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Depreciation implements ValuationPolicy{
	private Bike bike;
	private BigDecimal newReplacement;
	//= this.bike.getBikeType().getNewReplacementValue();
	private BigDecimal originalReplacement;
	//= this.bike.getBikeType().getOriReplacementValue();
	
	public Depreciation(Bike bike) {
		this.bike = bike;
		this.newReplacement = this.bike.getBikeType().getNewReplacementValue();
		this.originalReplacement = this.bike.getBikeType().getOriReplacementValue();
	}

	public void setDepreciatedBike(Bike bikeA){
		this.bike = bikeA;
	}
	
	public Bike getDepreciatedBike(){
		return this.bike;
	}
	
	public BigDecimal linearDepreciation(BigDecimal depreciationRate){
		BigDecimal depreciationExpense = this.originalReplacement.multiply(bike.getBikeAge().multiply(depreciationRate));
		this.newReplacement = this.originalReplacement.subtract(depreciationExpense);
		this.bike.getBikeType().setNewReplacementValue(this.newReplacement);
		return this.newReplacement;
	}
	
	public BigDecimal DoubleDecliningBalanceDepreciation(BigDecimal depreciationRate){
		BigDecimal one = new BigDecimal("1.0");
		BigDecimal two = new BigDecimal("2.0");
		
		BigDecimal depreciationExpense = (one.subtract(two.multiply(depreciationRate))).pow(bike.getBikeAge().intValue());
		BigDecimal endingPeriodValue = this.originalReplacement.multiply(depreciationExpense);
		this.newReplacement = endingPeriodValue;
		this.bike.getBikeType().setNewReplacementValue(this.newReplacement);
		return this.newReplacement;
	}
	
	@Override
	public BigDecimal calculateValue(Bike bike, LocalDate date) {
		return this.newReplacement;
	}
}
