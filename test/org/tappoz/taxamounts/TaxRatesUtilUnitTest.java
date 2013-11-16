package org.tappoz.taxamounts;

import static org.junit.Assert.*;

import org.junit.Test;
import org.tappoz.taxamounts.TaxRatesUtil;

public class TaxRatesUtilUnitTest
{
	@Test
	public void test_getTaxRangesUpperBound()
	{
		// in the first range
		assertEquals(1, TaxRatesUtil.getTaxRangesUpperBound(100));
		// in the second range
		assertEquals(2, TaxRatesUtil.getTaxRangesUpperBound(7000));
	}
	
	@Test
	public void test_getTaxRangesAboveTheLastLowerBound()
	{
		// above the last lower bound (i.e. in the last range)
		assertEquals(6, TaxRatesUtil.getTaxRangesUpperBound(50000));
		// the upper bound (included) of the 4th range
		assertEquals(4, TaxRatesUtil.getTaxRangesUpperBound(21240));
	}

	@Test
	public void test_getTaxRangesInABoundaryBetweenTwoDifferentRanges()
	{
		// the upper bound (included) of the 4th range
		assertEquals(4, TaxRatesUtil.getTaxRangesUpperBound(21240));
	}
	
	// --------------------------------------------
	
	@Test
	public void test_getTaxesAmountInFirstRange()
	{
		double amount = 1000;
		// the 3rd parameter is the delta
		assertEquals(100, TaxRatesUtil.getTaxesAmount(amount), 0.1);
	}
	
	@Test
	public void test_getTaxesAmountInAllRanges()
	{
		double amount = 50000;
		// 10000 * 0.45 = 4500
		// 18000 * 0.33 = 5940
		//  7000 * 0.3  = 2100
		//  6000 * 0.23 = 1380
		//  4000 * 0.14 =  560
		//  5000 * 0.1  =  500
		//
		// total: 14980
		
		// the 3rd parameter is the delta
		assertEquals(14980, TaxRatesUtil.getTaxesAmount(amount), 0.1);
	}
}
