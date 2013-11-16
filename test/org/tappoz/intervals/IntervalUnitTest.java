package org.tappoz.intervals;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntervalUnitTest
{
	@Test
	public void test_overlapping()
	{
		Interval first = new Interval(5, 10);
		Interval second = new Interval(10, 11);
		
		assertTrue(first.isOverlapping(second));
	}

	@Test
	public void test_notOverlapping()
	{
		Interval first = new Interval(5, 10);
		Interval second = new Interval(13, 12);
		
		// the intervals are not overlapping, 
		// then isOverlapping() is returning false
		assertFalse(first.isOverlapping(second));
	}
	
	@Test
	public void test_containingIntervals()
	{
		Interval first = new Interval(5, 10);
		Interval second = new Interval(7, 6);
		
		// first is containing second
		assertTrue(first.contains(second));
	}
	
	@Test
	public void test_compareToBefore()
	{
		Interval first = new Interval(5, 10);
		Interval second = new Interval(20, 25);
		
		// first is BEFORE (-1) second 
		assertEquals("!", -1, first.compareTo(second));
	}
	
	@Test
	public void test_compareToEquals()
	{
		Interval first = new Interval(5, 10);
		Interval second = new Interval(5, 25);
		
		// first is EQUAL (0) to second 
		assertEquals("!", 0, first.compareTo(second));
	}
	
	@Test
	public void test_compareToAfter()
	{
		Interval first = new Interval(5, 10);
		Interval second = new Interval(1, 2);
		
		// first is AFTER (1) second 
		assertEquals("!", 1, first.compareTo(second));
	}
}
