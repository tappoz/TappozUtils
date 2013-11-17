package org.tappoz.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumUtilsUnitTest
{
	@Test
	public void test_getNumberOfDistinctDigits()
	{
		assertEquals(1, NumUtils.getNumberOfDistinctDigits(999));
		assertEquals(4, NumUtils.getNumberOfDistinctDigits(1110002223));
	}
	
	// testing if an Exception is thrown
	@Test(expected=UnsupportedOperationException.class)
	public void test_getNumberOfDistinctDigitsThrowsException()
	{
		// the input integer must be greater than zero
		NumUtils.getNumberOfDistinctDigits(-999);
	}
	
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
	
	@Test
	public void test_firstUniqueNumberInInputArray()
	{
		// looking for the first unique value
		int[] inputArray = {1, 7, 5, 5, 1, 3};
		assertEquals(7, NumUtils.firstUniqueNumberInInputArray(inputArray));
	}
	
	@Test
	public void test_firstUniqueNumberInInputArrayNoUniqueValues()
	{
		// there is no unique values in the input array, then the method should return -1
		int[] inputArray = {5, 7, 7, 5, 5, 7};
		assertEquals(-1, NumUtils.firstUniqueNumberInInputArray(inputArray));
	}
}
