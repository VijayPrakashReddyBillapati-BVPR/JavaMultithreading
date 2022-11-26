package com.multithreadings.evenOdd;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		EvenOddPrinterSynchronization evenOddPrinterSynchronization = new EvenOddPrinterSynchronization(false);
		Thread t1 = new Thread(new TaskEvenOdd(10,evenOddPrinterSynchronization,true));
		Thread t2 = new Thread(new TaskEvenOdd(10,evenOddPrinterSynchronization,false));
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("---------------------------------------------------------");
		
		EvenOddPrinterSemaphores evenOddPrinterSemaphores = new EvenOddPrinterSemaphores();
		Thread t3 = new Thread(new TaskEvenOdd(10,evenOddPrinterSemaphores,true));
		Thread t4 = new Thread(new TaskEvenOdd(10,evenOddPrinterSemaphores,false));
		t3.start();
		t4.start();
		
		t3.join();
		t4.join();
	}
}
