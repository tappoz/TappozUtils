package org.tappoz.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumUtilsUnitTest
{
	@Test(expected=UnsupportedOperationException.class)
	public void test_wrongInputValuesFor_getNumberOfDivisibleIntegersInRange()
	{
		// the lower bound must be less or equal to the upper bound
		NumUtils.getNumberOfDivisibleIntegersInRange(10, 5, 2);
	}
	
	@Test
	public void test_getNumberOfDivisibleIntegersInRange()
	{
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(1, 22, 5));
		assertEquals(4, NumUtils.getNumberOfDivisibleIntegersInRange(5, 20, 5));
	}

}
