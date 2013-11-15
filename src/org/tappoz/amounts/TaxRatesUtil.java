package org.tappoz.amounts;

import java.util.Arrays;

public class TaxRatesUtil
{
	private static int taxRanges[] = {0, 5070, 8660, 14070, 21240, 40230};
	private static double taxRates[] = {0, 0.1, 0.14, 0.23, 0.3, 0.33, 0.45};
	
	public static int getTaxRangesUpperBound(int amount){
		
		int index = Arrays.binarySearch(taxRanges, amount);
		if (index >= 0) return index;
		// http://docs.oracle.com/javase/1.4.2/docs/api/java/util/Arrays.html#binarySearch%28int[],%20int%29
		else return - index - 1;
	}
}
