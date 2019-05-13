package com.shan.designPatterns;

public class SingletonExample {

	static SingletonExample instance;

	private SingletonExample() {

	}

	static SingletonExample getInstance() {

		if (instance == null) {
			synchronized (SingletonExample.class) {
				if (instance == null) {
					instance = new SingletonExample();
				}
			}
		}
		return instance;

	}
	
	private static class BillPughSingleton{
		private static final SingletonExample INSTANCE = new SingletonExample();
	}
	
	static SingletonExample getInstance2() {
		return BillPughSingleton.INSTANCE;
	}

}
