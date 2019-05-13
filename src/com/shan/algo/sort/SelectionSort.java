package com.shan.algo.sort;

import java.util.Arrays;

public class SelectionSort {
	
	// identify minimum of the array recursively
	public static void main(String[] args) {
		int[] arr = { 11, 56, 21, 10, 9, 104, 376 };
		selectionSort(arr);
		Arrays.stream(arr).forEach(System.out::println);
	}

	private static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			int minIndex = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
				
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

}
