package com.multithreadings.uberride;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class UberRide implements IUberRide {

	private Integer democrates=0;
	private Integer republican=0;
	
	 CyclicBarrier barrier = new CyclicBarrier(4);
	 ReentrantLock lock = new ReentrantLock();
	 
	 private Semaphore demsWaiting = new Semaphore(0);
	 private Semaphore repubsWaiting = new Semaphore(0);
	
	@Override
	public void seatDemocrat() throws InterruptedException, BrokenBarrierException {
		
		boolean rideLeader=false;
		lock.lock();
		
		democrates++;
		
		if(democrates==4)
		{
			demsWaiting.release(3);
			democrates-=4;
			rideLeader = true;
		}else if(democrates==2 && republican >=2)
		{
			demsWaiting.release(1);
			repubsWaiting.release(2);
			democrates-=2;
			republican-=2;
			rideLeader = true;
		}else {
			lock.unlock();
			demsWaiting.acquire();
		}
		seated();
		barrier.await();
		
		if(rideLeader == true)
		{
			drive();
			lock.unlock();
		}
				
	}

	@Override
	public void seatRepublican() throws InterruptedException, BrokenBarrierException {
		
		boolean rideLeader=false;
		lock.lock();
		republican++;
		
		if(republican ==4)
		{
			repubsWaiting.release(3);
			republican-=4;
			rideLeader = true;
		}else if(republican ==2 && democrates >=2)
		{
			demsWaiting.release(2);
			repubsWaiting.release(1);
			republican-=2;
			democrates-=2;
			rideLeader = true;
		}else {
			lock.unlock();
			repubsWaiting.acquire();
		}
		
		seated();
		barrier.await();
		
		if(rideLeader == true)
		{
			drive();
			lock.unlock();
		}
	}

	@Override
	public void seated() {
		 System.out.println(Thread.currentThread().getName() + "  seated");
	     System.out.flush();
	}

	@Override
	public void drive() {
		System.out.println("Uber Ride on Its wayyyy... with ride leader " + Thread.currentThread().getName());
        System.out.flush();
	}

}
