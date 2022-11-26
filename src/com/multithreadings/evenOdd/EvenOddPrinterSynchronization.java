package com.multithreadings.evenOdd;

public class EvenOddPrinterSynchronization  implements EvenOddPrinter{
	
	public volatile boolean isEven = false;

	public EvenOddPrinterSynchronization(boolean isEven) {
		this.isEven = isEven;
	}

	@Override
	public synchronized void printEven(Integer Numbers)
	{
		while(!isEven)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+" : "+Numbers);
		isEven = false;
		notify();
	}
	
	@Override
	public synchronized void printOdd(Integer Numbers)
	{
		while(isEven)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+" : "+Numbers);
		isEven = true;
		notify();
	}
	
}
