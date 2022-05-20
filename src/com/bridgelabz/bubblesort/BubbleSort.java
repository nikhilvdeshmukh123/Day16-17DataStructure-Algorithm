package com.bridgelabz.bubblesort;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] list = {12,78,9,2,3,45};
		BubbleSort.sortList(list);
	}

	private static void sortList(int[] list) {

		int temp;
		for(int i=0; i<list.length; i++) {
			int flag = 0;
			for(int j=0; j<list.length-1-i; j++) {
				if(list[j] > list[j+1]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					flag = 1;
				}
			}
			if(flag == 0) {
				break;
			}
		}
		for(int i=0; i<list.length; i++) {
			System.out.print(list[i]+" ");
		}
		
	}

}
