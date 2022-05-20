package com.bridgelabz.cashcounter;

public class Main {

	public static void main(String[] args) {
		CashCounter counter = new CashCounter();
		counter.enqueue(500);
		counter.enqueue(1000);
		counter.enqueue(200);
		counter.dequeue();
		System.out.println(counter.noOfPersonInQueue());

	}

}
