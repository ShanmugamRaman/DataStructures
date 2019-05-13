package com.shan.algo.arrays;

import java.util.Arrays;

public class SegregateZerosOnes {
	
	public static void main(String[] args) {
		
		int arr[] = {0,1,0,0,1,0,1,0};
		segregateZerosOnes(arr);
		
	}

	private static void segregateZerosOnes(int[] arr) {
		
		int head = 0, rear = arr.length - 1;
		
		while(head < rear) {
			//find first 1 from front
			while(arr[head] == 0 && head < arr.length)
				head++;
			
			//find first 0 from rear
			while(arr[rear] == 1 && rear >= 0)
				rear--;
			
			if(head < rear) {
				int temp = arr[head];
				arr[head] = arr[rear];
				arr[rear] = temp;
				
				head++;
				rear--;
			}
		}
		
		Arrays.stream(arr).forEach(System.out::println);
		
	}

}
