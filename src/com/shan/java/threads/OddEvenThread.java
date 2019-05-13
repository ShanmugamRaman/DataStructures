package com.shan.java.threads;

public class OddEvenThread {
	
	private boolean isOdd = true;
	int currValue = 1;
	final int MAX_NUMBER = 20;
		
	public void printOdd(){
		synchronized (this) {
			while(currValue < MAX_NUMBER) {
				
				while(!isOdd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(Thread.currentThread().getName()+" prints : "+currValue);
				currValue++;
				isOdd = false;
				notify();
			}
		}
	}
	
	public void printEven(){
		synchronized (this) {
			while(currValue < MAX_NUMBER) {
				
				while(isOdd) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(Thread.currentThread().getName()+" prints : "+currValue);
				currValue++;
				isOdd = true;
				notify();
			}
		}
	}
	
	public static void main(String[] args) {
		
		OddEvenThread oet = new OddEvenThread();
		
		Thread oddThread = new Thread(() -> oet.printOdd(), "OddThread");
		Thread evenThread = new Thread(() -> oet.printEven(), "EvenThread");
		
		oddThread.start();
		evenThread.start();
		
	}

}
