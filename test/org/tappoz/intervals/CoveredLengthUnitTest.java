package org.tappoz.intervals;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoveredLengthUnitTest
{
	@Test
	public void test_notOverlapping()
	{
		Interval first = new Interval(5, 8);
		Interval second = new Interval(10, 11);
		Interval[] intervals = {first, second};
		
		// (8 - 5) + (11 - 10)
		assertEquals(4, CoveredLength.findCoveredLength(intervals), 0);
	}
	
	@Test
	public void test_overlapping()
	{
		Interval first = new Interval(5, 10);
		Interval second = new Interval(8, 11);
		Interval[] intervals = {first, second};
		
		// 11 - 5
		assertEquals(6, CoveredLength.findCoveredLength(intervals), 0);
	}
	
	@Test
	public void test_anotherArrayOfIntervals()
	{
		Interval[] intervals = new Interval[3];
		
	 	intervals[0] = new Interval(3.7, 2.9);
		intervals[1] = new Interval(-6.0, -6.3);
		intervals[2] = new Interval(3.6, 4.2);
		
		// (-6.0 - (-6.3)) + (4.2 - 2.9)
		assertEquals(1.6, CoveredLength.findCoveredLength(intervals), 0);
	}
	
	@Test
	public void test_intervalContainingAnotherInterval()
	{
		Interval first = new Interval(5, 10);
		Interval second = new Interval(8, 9);
		Interval[] intervals = {first, second};
		
		// 10 - 5
		assertEquals(5, CoveredLength.findCoveredLength(intervals), 0);
	}
}
