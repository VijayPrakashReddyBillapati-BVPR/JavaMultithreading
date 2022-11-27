package com.multithreadings.unisexbathroom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UnisexBathroomNoStarvation implements IUnisexBathroom {

	int empsInBathroom = 0;
	final static int MAX_CAPACITY = 3;
	private ReentrantLock lock = new ReentrantLock();
	private Condition menWaiting = lock.newCondition();
	private Condition womenWaiting = lock.newCondition();
	private int womenWaitingN = 0;
	private int menWaitingN = 0;
	private int womenUsingN = 0;
	private int menUsingN = 0;


	void useBathroom(String name) throws InterruptedException {
		System.out.println(name + " using bathroom. Current employees in bathroom = " + empsInBathroom);
		Thread.sleep(10000);
		System.out.println(name + " done using bathroom");
	}

	@Override
	public void maleUseBathroom(String name) throws InterruptedException {

		lock.lock();
		menWaitingN = menWaitingN + 1;

		while (empsInBathroom == MAX_CAPACITY || womenUsingN >0) {
			menWaiting.await();
		}

		empsInBathroom = empsInBathroom + 1;
		menUsingN = menUsingN + 1;
		menWaitingN = menWaitingN - 1;
		lock.unlock();

		useBathroom(name);

		lock.lock();
		menUsingN = menUsingN - 1;
		empsInBathroom = empsInBathroom - 1;
		if (womenWaitingN > 0) {
			womenWaiting.signal();
		} else {
			menWaiting.signal();
		}

		lock.unlock();

	}

	@Override
	public void femaleUseBathroom(String name) throws InterruptedException {
		lock.lock();

		womenWaitingN = womenWaitingN + 1;

		while (empsInBathroom == MAX_CAPACITY || menUsingN >0) {
			womenWaiting.await();
		}

		empsInBathroom = empsInBathroom + 1;
		womenUsingN = womenUsingN + 1;
		womenWaitingN = womenWaitingN - 1;
		lock.unlock();

		Thread.sleep(5000);
		useBathroom(name);

		lock.lock();
		womenUsingN = womenUsingN - 1;
		empsInBathroom = empsInBathroom - 1;
		if (menWaitingN > 0) {
			Thread.sleep(1000);
			menWaiting.signal();
		} else {
			womenWaiting.signal();
		}
		lock.unlock();
	}

}
