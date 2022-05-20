package com.bridgelabz.orderedlist;

import java.util.Scanner;

public class Main {

	public static  void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number to search :");
		Integer input = scan.nextInt();
		OrdereList<Integer> func = new OrdereList<Integer>(input);
		func.ascOrder();
		func.show();
		System.out.println(func.search());
		func.show();
	}

}
