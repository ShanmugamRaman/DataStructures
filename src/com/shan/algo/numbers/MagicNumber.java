package com.shan.algo.numbers;

public class MagicNumber {
	
	public static void main(String[] args) {
		int number = 50113;
		checkIfMagicNumber(number);
	}

	private static void checkIfMagicNumber(int number) {
		int sum = 0, currNumber = number;
		while(currNumber > 0 || sum > 9 ) {
			if(currNumber == 0) {
				currNumber = sum;
				sum = 0;
			}
			sum += currNumber % 10;
			currNumber = currNumber / 10;
		}
		if(sum == 1) {
			System.out.println("Magic Number : "+number);
		}else {
			System.out.println("Not a Magic Number : "+number);
		}
	}

}
