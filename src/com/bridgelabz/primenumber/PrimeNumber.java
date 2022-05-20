package com.bridgelabz.primenumber;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Range 0-1000 prime number is : ");
		int start = 0;
		int stop = 1000;
		for(int i = start; i<=stop; i++) {
			if(isPrime(i)) 
				System.out.println(i);
		}
	}

	private static boolean isPrime(int number) {
		int count = 0;
		if(number < 2)
			return false;
		for (int i = 2; i<number; i++) {
			if(number % i == 0) 
				return false;
		}
		return true;
	}
}
