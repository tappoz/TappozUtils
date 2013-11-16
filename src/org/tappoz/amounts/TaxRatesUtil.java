package org.tappoz.amounts;

import java.util.Arrays;

public class TaxRatesUtil
{
	private static double taxRanges[] = {0, 5000, 9000, 15000, 22000, 40000};
	private static double taxRates[] = {0, 0.1, 0.14, 0.23, 0.3, 0.33, 0.45};
	private static double taxRatesAmounts[] = {0, 0, 0, 0, 0, 0, 0};
	
	public static int getTaxRangesUpperBound(double amount){
		
		if (amount < 0)
			throw new UnsupportedOperationException("The amount must be greater than zero!");
		
		int index = Arrays.binarySearch(taxRanges, amount);
		if (index > 0) return index;
		else return - index - 1; // cfr. official documentation of the binary search for this 
	}
	
	public static double getTaxesAmount(double amount)
	{	
    	int index = getTaxRangesUpperBound(amount);
    	
    	if (index == 1)
    	{
    		return amount * taxRates[index];
    	}
    	else
    	{
    		double amountInCurrentRange = amount - taxRanges[index - 1];
    		// recursion here with the left amount on which the taxes will be computed
    		return amountInCurrentRange * taxRates[index] + getTaxesAmount(taxRanges[index - 1]);
    	}
    }
}
