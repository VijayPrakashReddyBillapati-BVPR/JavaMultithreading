package com.multithreadings.unisexbathroom;

import java.util.concurrent.Semaphore;

public class UnisexBathroom implements IUnisexBathroom{

	private static final String WOMEN = "women";
	private static final String MEN = "men";
	private static final String NONE = "none";
	
	String inUseBy = NONE;
	int empsInBathroom = 0;
	int max = 3;
	Semaphore maxEmps = new Semaphore(3);
	
	void useBathroom(String name) throws InterruptedException {
		System.out.println(name + " using bathroom. Current employees in bathroom = " + empsInBathroom);
		Thread.sleep(10000);
		System.out.println(name + " done using bathroom");
		}
	
	@Override
	public void maleUseBathroom(String name) throws InterruptedException {
		
		synchronized(this)
		{
			while(inUseBy.equals(WOMEN))
				wait();
			
			maxEmps.acquire();
			empsInBathroom++;
			inUseBy = MEN;
		}
		
		useBathroom(name);
		maxEmps.release();
		
		synchronized(this)
		{
			empsInBathroom--;
			
			if(empsInBathroom==0)
				inUseBy = NONE;
			
			this.notifyAll();
		}
	}

	@Override
	public void femaleUseBathroom(String name) throws InterruptedException {
		synchronized(this)
		{
			while(inUseBy.equals(MEN))
				wait();
			
			maxEmps.acquire();
			empsInBathroom++;
			inUseBy = WOMEN;
		}
		
		useBathroom(name);
		maxEmps.release();
		
		synchronized(this)
		{
			empsInBathroom--;
			
			if(empsInBathroom==0)
				inUseBy = NONE;
			
			this.notifyAll();
		}
	}

}
