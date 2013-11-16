package org.tappoz.math;

public class NumUtils
{
	/**
	 * Given an integer inputInteger, this method returns the number of distinct digits that occur 
	 * in the decimal representation of inputInteger (without leading zeros). For example: 
	 * <ul>
	 * <li> given inputInteger = 1519 the function should return 3, because there are three distinct digits in the 
	 * representation of inputInteger, namely 1, 5 and 9. </li>
	 * <li> given inputInteger = 222 the function should return 1, because only one distinct digit occurs in the 
	 * representation of inputInteger, namely 2. </li>
	 * </ul>
	 * 
	 * @param inputInteger the input value to analyse
	 * @return
	 */
	public static int getDistinctDigits(int inputInteger)
	{
		int[] availableDigits = new int[10];
		int counter = 0;
        int currentDigit;
        
        while (inputInteger > 0)
        {
        	currentDigit = inputInteger % 10;
        	if (availableDigits[currentDigit] == 0)
        	{
        		availableDigits[currentDigit] = 1;
        		counter++;
        	}
        	inputInteger = inputInteger / 10;
        }
        return counter;
	}
	
	/**
	 * Given three integers 
	 * <ul>
	 * <li>lowerBoundInRange,</li>
	 * <li>upperBoundInRange,</li>
	 * <li>divisor</li>
	 * this method returns the number of integers within the range that are divisible by divisor.
	 * For example, for lowerBoundInRange = 6, upperBoundInRange = 11 and divisor = 2, the method 
	 * returns 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
	 * 
	 * @param lowerBoundInRange the lower bound of the input range
	 * @param upperBoundInRange the upper bound of the input range
	 * @param divisor
	 * @return
	 */
	public static int getNumberOfDivisibleIntegersInRange
	(int lowerBoundInRange, int upperBoundInRange, int divisor) 
	{
		if (lowerBoundInRange > upperBoundInRange)
			throw new UnsupportedOperationException("the first parameter (the lower bound) should be less than the second parameter (the upper bound)");
		else if (lowerBoundInRange == upperBoundInRange)
		    return 1;
		
		int out = (int) Math.ceil( (upperBoundInRange - lowerBoundInRange) / divisor );
		
		if (upperBoundInRange % divisor == 0)
		    return ++out;
		return out;
	 }
}
