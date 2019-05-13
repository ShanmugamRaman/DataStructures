package com.shan.algo.sort;

public class BinarySearch {
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,63,72,81,90,99};
		int left = 0, right = arr.length-1;
		
		int position = binarySearch(arr, 100, left, right);
		System.out.println("Found at "+position);
	}

	private static int binarySearch(int[] arr, int key, int left, int right) {
		if(right > left) {
			int mid = left + (right-left)/2;
			
			if(arr[mid] == key) {
				return mid;
			}else if (key < arr[mid]) {
				return binarySearch(arr, key, left, mid-1);
			}else {
				return binarySearch(arr, key, mid+1, right);
			}
		}
		return -1;
	}

}
