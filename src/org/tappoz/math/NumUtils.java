package org.tappoz.math;

import java.util.Arrays;

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
	 * </ul>
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
		
		int out = (int) Math.ceil( (double) (upperBoundInRange - lowerBoundInRange) / (double) divisor );
		
		if (upperBoundInRange % divisor != 0 && lowerBoundInRange % divisor != 0)
			return --out;
		if (upperBoundInRange % divisor == 0 && lowerBoundInRange % divisor == 0)
		    return ++out;
		return out;
	}
	
	/**
	 * Given an array inputArray of N integers, this method returns the first unique number in inputArray. 
	 * In other words this method returns the unique number with the lowest position in inputArray. 
	 * The method returns −1 if there are no unique numbers in inputArray.
	 * 
	 * For example:
	 * <ul>
	 * <li> given {1, 7, 5, 5, 1, 3} the method will return 7 </li>
	 * <li> given {5, 7, 7, 5, 5} the method will return -1 </li>
	 * </ul>
	 * 
	 * @param inputArray
	 * @return
	 */
	public static int firstUniqueNumberInInputArray(int[] inputArray) 
	{
		// a sorted version of the input array
    	int[] sortedInputArray = new int[inputArray.length];
    	System.arraycopy( inputArray, 0, sortedInputArray, 0, inputArray.length);
    	Arrays.sort(sortedInputArray);
    	
    	// looking for unique numbers in the input array
    	for (int i = 0; i < inputArray.length; i++)
    	{
    		// from the documentation:
    		// If the array contains multiple elements with the specified value, 
    		// there is no guarantee which one will be found.
    		// => we need to verify the previous element and the following element
    		int indexInSortedArray = Arrays.binarySearch(sortedInputArray, inputArray[i]);
    		if 
    		(
    			// the first element in the sorted array
    			(	indexInSortedArray == 0 && 
    				sortedInputArray[indexInSortedArray + 1] != sortedInputArray[indexInSortedArray]
    			) ||
    			// the last element in the sorted array
    			(	indexInSortedArray == (inputArray.length - 1) && 
					sortedInputArray[indexInSortedArray - 1] != sortedInputArray[indexInSortedArray]
    			) ||
    			// an element in somewhere inside the array but not at the boundaries
    			(	indexInSortedArray != 0 && 
    				indexInSortedArray != (inputArray.length - 1) && 
    				sortedInputArray[indexInSortedArray - 1] != sortedInputArray[indexInSortedArray] &&
    				sortedInputArray[indexInSortedArray + 1] != sortedInputArray[indexInSortedArray]
    			)
    		)
    			// we found a unique value
    			return inputArray[i];
    	}
    	
    	// we did not find any unique number
    	return -1;
    }
}
