package org.tappoz.amounts;

import static org.junit.Assert.*;

import org.junit.Test;

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
}
