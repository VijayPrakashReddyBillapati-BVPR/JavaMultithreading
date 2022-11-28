package com.multithreadings.diningphilosophers;

public class Demonstration {

	public static void main(String[] args) {
		try {
			DiningPhilosophers.runTest();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}