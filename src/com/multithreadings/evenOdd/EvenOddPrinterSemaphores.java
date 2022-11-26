package com.multithreadings.evenOdd;

import java.util.concurrent.Semaphore;

public class EvenOddPrinterSemaphores implements EvenOddPrinter{

	Semaphore even = new Semaphore(0);
	Semaphore odd = new Semaphore(1);
	
	@Override
	public void printEven(Integer Numbers)
	{
		try {
			even.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" : "+Numbers);
		odd.release();
	}
	
	@Override
	public void printOdd(Integer Numbers)
	{
		try {
			odd.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" : "+Numbers);
		even.release();
	}
	
}
