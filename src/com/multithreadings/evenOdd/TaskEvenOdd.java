package com.multithreadings.evenOdd;

public class TaskEvenOdd implements Runnable {

	private EvenOddPrinter printer;
	private Integer max;
	private boolean isEven;
	
	public TaskEvenOdd(Integer numbers,EvenOddPrinter printer,boolean isEven) {
		this.max = numbers;
		this.printer = printer;
		this.isEven = isEven;
	}

	@Override
	public void run() {
		Integer number = isEven ? 2 : 1;
		while(number<=max)
		{
			if(isEven){
					this.printer.printEven(number);
			}else{
					this.printer.printOdd(number);
			}
			number += 2;
		}
	}

}
