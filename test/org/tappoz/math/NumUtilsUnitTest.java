package org.tappoz.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumUtilsUnitTest
{
	// testing if an Exception is thrown
	@Test(expected=UnsupportedOperationException.class)
	public void test_wrongInputValuesFor_getNumberOfDivisibleIntegersInRange()
	{
		// the lower bound (first parameter) must be less or equal to the upper bound (second parameter)
		NumUtils.getNumberOfDivisibleIntegersInRange(10, 5, 2);
	}
	
	@Test
	public void test_getNumberOfDivisibleIntegersInRange()
	{
		// both bounds not divisible
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(1, 22, 5));
		// both bounds divisible
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(5, 20, 5));
		// only lower bound divisible
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(5, 22, 5));
		// only upper bound divisible
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(1, 20, 5));
	}

	@Test
	public void test_getNumberOfDivisibleIntegersInRangeBothNegative()
	{
		// this test is concerned with negative integers as boundaries
		
		// both bounds not divisible
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(-22, -1, 5));
		// both bounds divisible
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(-20, -5, 5));
		// only lower bound divisible
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(-20, -1, 5));
		// only upper bound divisible
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(-22, -5, 5));
	}
}
