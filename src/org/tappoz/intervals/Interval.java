package org.tappoz.intervals;

public class Interval implements Comparable<Interval>
{
	private double startMoment;
    private double stopMoment;
    
    public Interval(double a, double b) 
    {
    	if (a <= b)
    	{
	    	this.startMoment = a;
	    	this.stopMoment = b;
    	}
    	else
    	{
    		this.startMoment = b;
	    	this.stopMoment = a;
    	}
    }
    
    public double getStartMoment() { 
    	return startMoment;  
    }
    public double getStopMoment() { 
    	return stopMoment; 
    }
    
    // are the two intervals overlapping?
    public boolean isOverlapping(Interval comparingInterval) 
    {
        Interval thisInterval = this;
        
        if (thisInterval.startMoment > comparingInterval.stopMoment)
        	return false;
        else if (thisInterval.stopMoment < comparingInterval.startMoment)
        	return false;
        else
        	return true;
    }
    
    // find if this interval contains another given one
    public boolean contains(Interval anotherInterval)
    {
    	if (	this.startMoment <= anotherInterval.startMoment &&
    			this.stopMoment  >= anotherInterval.stopMoment )
    		return true;
    	return false;
    }
    
    // comparing two intervals means knowing which one starts first
    public int compareTo(Interval comparingInterval) 
    {
    	final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        
	    if(this.startMoment < comparingInterval.startMoment) {
	    	return BEFORE;
	    }
	    else if(this.startMoment > comparingInterval.startMoment) {
	    	return AFTER;
	    }
	    return EQUAL;
    }
}
