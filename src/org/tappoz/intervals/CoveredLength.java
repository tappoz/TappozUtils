package org.tappoz.intervals;

import java.util.Arrays;

public class CoveredLength
{
	public static double findCoveredLength(Interval[] intervals)
	{	
    	double coveredLenght = 0;
    	boolean previousIntervalWasOverlappling = false;
    	Arrays.sort(intervals);
    	
    	for (int i = 0; i <= (intervals.length - 2); i++)
    	{
    		// the two intervals are not overlapping
    		if (!intervals[i].isOverlapping(intervals[i+1])) 
    		{
    			coveredLenght += (intervals[i].getStopMoment() - intervals[i].getStartMoment());
    			previousIntervalWasOverlappling = false;
    		}
    		// there is overlap, the current interval contains the next one
    		else if (intervals[i].contains(intervals[i+1]))
    		{
    			coveredLenght += (intervals[i].getStopMoment() - intervals[i].getStartMoment());
    			i++; // we do not want to process the next Interval as we are processing it now
    			previousIntervalWasOverlappling = true;
    		}
    		// there is an overlap, the current interval does NOT contain the next one
    		else{
    			coveredLenght += (intervals[i+1].getStopMoment() - intervals[i].getStartMoment());
    			i++; // we do not want to process the next Interval as we are processing it now
    			previousIntervalWasOverlappling = true;
    		}
    		
    	}
    	
    	// we need to process the last Interval saved in the array
    	if (!previousIntervalWasOverlappling)
    		coveredLenght += (intervals[intervals.length - 1].getStopMoment() - intervals[intervals.length - 1].getStartMoment());
    	
    	return coveredLenght;
    }
}
