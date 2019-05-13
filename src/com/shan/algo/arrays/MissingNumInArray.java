package com.shan.algo.arrays;

public class MissingNumInArray {
	
	public static void main(String[] args) {
		int arr[] = {1,3,4,5}, n = 5;
		findMissingNum(arr, n);
	}

	private static void findMissingNum(int[] arr, int n) {
		int allXor = 1, arrXor = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			arrXor ^= arr[i];
		}

		for (int i = 2; i <= n; i++) {
			allXor ^= i;
		}
		
		System.out.println("Missing number :"+(allXor ^ arrXor));
		
	}

}
