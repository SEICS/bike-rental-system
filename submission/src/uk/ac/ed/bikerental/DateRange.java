package uk.ac.ed.bikerental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.function.BooleanSupplier;

public class DateRange {
    private LocalDate start, end;
    
    /*@param start       - the start date
      @param end         - the end date*/
    public DateRange(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }
    
    /*@return */
    public LocalDate getStart() {
        return this.start;
    }
    
    /*@return */
    public LocalDate getEnd() {
        return this.end;
    }

    /*@return */
    public long toYears() {
        return ChronoUnit.YEARS.between(this.getStart(), this.getEnd());
    }
    
    /*@return */
    public long toDays() {
        return ChronoUnit.DAYS.between(this.getStart(), this.getEnd());
    }
    
    /*@return */
    public int getStartYear(){
    	return this.start.getYear();
    }
    
    /*@return */
    public int getEndYear(){
    	return this.end.getYear();
    }
    
    /*@return */
    public int getStartMonth(){
    	return this.start.getMonthValue();
    }
    
    /*@return */
    public int getEndMonth(){
    	return this.end.getMonthValue();
    }

    /*@param other         - a DateRange instance to check if a DateRange instance is overlapped with it*/
    /*@return */
    public Boolean overlaps(DateRange other) {
        // TODO: implement date range intersection checking
    	LocalDate otherStart = other.getStart();
    	LocalDate otherEnd = other.getEnd();
    	int otherStartYear = otherStart.getYear();
    	int otherEndYear = otherEnd.getYear();
    	int otherStartMonth = otherStart.getMonthValue();
    	int otherEndMonth = otherEnd.getMonthValue();
    	boolean overlap = false;
    	
    	if ((otherStartYear >= this.start.getYear()) && (otherStartYear <= this.end.getYear())){
    		if ((otherStartMonth >= this.start.getMonthValue()) && (otherStartMonth <= this.end.getMonthValue())){
    			overlap = true;
    		}
    	}
    	
    	return overlap;
        //assert false;
    }

    /*@return */
    @Override
    public int hashCode() {
        // hashCode method allowing use in collections
        return Objects.hash(end, start);
    }

    /*@return */
    @Override
    public boolean equals(Object obj) {
        // equals method for testing equality in tests
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DateRange other = (DateRange) obj;
        return Objects.equals(end, other.end) && Objects.equals(start, other.start);
    }
    
    // You can add your own methods here
}
