package com.bridgelabz.insertionsort;

public class InsertionSort {

	public String[] sortArray(String array[], int n) {
		
		for(int i=1; i<array.length; i++) {
			String temp = array[i];
	        int j = i - 1;
	        while (j >= 0 && temp.length() < array[j].length())
	        {
	            array[j+1] = array[j];
	            j--;
	        }
	        array[j+1] = temp;
		}
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		return array;	
	}
	
	public static void main(String[] args) {
		
		InsertionSort sort = new InsertionSort();
		
		String[] array = {"Jayesh","Nikita","Neha","Ashwini"};
		System.out.println("Before insertion sort");
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		int n = array.length;
		
		System.out.println("\nAfter insertion sort");
		sort.sortArray(array,n);
	}

}
