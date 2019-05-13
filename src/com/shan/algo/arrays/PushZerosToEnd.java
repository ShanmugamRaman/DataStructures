package com.shan.algo.arrays;

public class PushZerosToEnd {

	public static void main(String[] args) {
		int[] arr = {9,3,0,4,0,5,6,0};
		pushZerosToBack(arr);
		pushZerosToFront(arr);
	}

	private static void pushZerosToBack(int[] arr) {
		int i = 0, nonZerosCount = 0;
		while(i<arr.length) {
			if(arr[i] != 0) {
				arr[nonZerosCount] = arr[i];
				nonZerosCount ++;
			}
			i++;
		}
		
		for(i = nonZerosCount; i<arr.length; i++) {
			arr[i] = 0;
		}
		
		System.out.println("Pushing zeros to end..");
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	
	private static void pushZerosToFront(int[] arr) {
		int i = arr.length-1, zerosCount = arr.length-1;
		while(i>=0) {
			if(arr[i] != 0) {
				arr[zerosCount] = arr[i];
				zerosCount--;
			}
			i--;
		}
		
		for(i = 0; i<=zerosCount; i++) {
			arr[i] = 0;
		}
		
		System.out.println("Pushing zeros to front..");
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
}
