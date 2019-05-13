package com.shan.algo.arrays;

import java.util.Arrays;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = {1,4,9,16,25};
		int[] arr2 = {2,5,8,11,36};
		
		mergeTwoSortedArrays(arr1,arr2);
	}

	private static void mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		
		int arr1Length = arr1.length, head1 = 0;
		int arr2Length = arr2.length, head2 = 0;
		
		int[] resultantArray = new int[arr1Length + arr2Length];
		int i;
		for(i = 0; i<resultantArray.length-1; i++) {
			if(arr1[head1] < arr2[head2]) {
				resultantArray[i] = arr1[head1];
				head1++;
			}else {
				resultantArray[i] = arr2[head2];
				head2++;
			}
		}

		while(head1 < arr1Length){
			resultantArray[i++] = arr1[head1];
			head1++;
		}
		
		while(head2 < arr2Length){
			resultantArray[i++] = arr2[head2];
			head2++;
		}
		
		/*int i = 0, j = 0, k = 0; 
	      
        // Traverse both array 
        while (i<arr1Length && j <arr2Length) 
        { 
            if (arr1[i] < arr2[j]) 
                resultantArray[k++] = arr1[i++]; 
            else
                resultantArray[k++] = arr2[j++]; 
        } 
      
        // Store remaining elements of first array 
        while (i < arr1Length) 
            resultantArray[k++] = arr1[i++]; 
      
        // Store remaining elements of second array 
        while (j < arr2Length) 
            resultantArray[k++] = arr2[j++]; 
		*/
		Arrays.stream(resultantArray).forEach(System.out::println);
		
	}
	
}
