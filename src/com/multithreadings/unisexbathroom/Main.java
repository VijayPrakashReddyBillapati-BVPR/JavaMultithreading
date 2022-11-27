package com.multithreadings.unisexbathroom;

public class Main {

	public static void main(String[] args) {
		try {
//			Test.unisexBathroom = new UnisexBathroomNoStarvation();
			Test.unisexBathroom = new UnisexBathroom();
			Test.runTest();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
