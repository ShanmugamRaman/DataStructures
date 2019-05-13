package com.shan.algo.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 11, 56, 21, 10, 9, 104, 376 };
		insertionSort(arr);
		Arrays.stream(arr).forEach(System.out::println);
	}

	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

}
