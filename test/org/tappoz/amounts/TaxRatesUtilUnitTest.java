package org.tappoz.amounts;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxRatesUtilUnitTest
{

	@Test
	public void testTaxRangesUpperBound()
	{
		assertEquals(1, TaxRatesUtil.getTaxRangesUpperBound(100));
		assertEquals(2, TaxRatesUtil.getTaxRangesUpperBound(7000));
		assertEquals(6, TaxRatesUtil.getTaxRangesUpperBound(50000));
		assertEquals(4, TaxRatesUtil.getTaxRangesUpperBound(21240));
	}

}
