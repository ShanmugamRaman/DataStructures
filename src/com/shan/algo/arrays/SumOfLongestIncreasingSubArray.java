package com.shan.algo.arrays;

public class SumOfLongestIncreasingSubArray {
	
	public static void main(String[] args) {
		int[] arr = {-3,-5,7,-1,2,3,8,9};
		sumOfLIS(arr);
		printLIS(arr);
	}

	private static void sumOfLIS(int[] arr) {
		int maxSoFar = Integer.MIN_VALUE, currSum=0;
		for(int i = 0; i<arr.length; i++) {
			currSum = currSum + arr[i];
			if (currSum < 0)
				currSum = 0;
			else if (maxSoFar < currSum)
				maxSoFar = currSum;
		}
		System.out.println("Sum of LIS : "+maxSoFar);

		maxSoFar = arr[0];
		currSum = arr[0]; 
	  
	    for (int i = 1; i < arr.length; i++) { 
           currSum = Math.max(arr[i], currSum + arr[i]); 
           maxSoFar = Math.max(maxSoFar, currSum); 
	    } 
	    
		System.out.println("Sum of LIS : "+maxSoFar);
	}
	
	static void printLIS(int arr[]) 
    { 
        int maxSoFar = Integer.MIN_VALUE, currSum = 0
        		,start = 0, end = 0, s = 0, size = arr.length; 
  
        for (int i = 0; i < size; i++)  
        { 
            currSum += arr[i]; 
  
            if (maxSoFar < currSum)  
            { 
                maxSoFar = currSum; 
                start = s; 
                end = i; 
            } 
  
            if (currSum < 0)  
            { 
                currSum = 0; 
                s = i + 1; 
            } 
        } 
        System.out.println("Maximum contiguous sum is " + maxSoFar); 
        System.out.println("Starting index " + start); 
        System.out.println("Ending index " + end); 
    } 
  

}
