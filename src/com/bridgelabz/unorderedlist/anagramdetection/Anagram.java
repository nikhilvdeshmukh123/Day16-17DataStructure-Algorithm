package com.bridgelabz.unorderedlist.anagramdetection;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first word");
		String word = input.next();
		System.out.println("Enter second word");
		String word1 = input.next();
		
		Anagram.anagram(word, word1);
		 if (anagram(word, word1))
	            System.out.println("The two strings are anagram of each other");
	        else
	            System.out.println("The two strings are not anagram of each other");
	}

	private static boolean anagram(String word, String word1) {
		
		if(word.length() != word1.length()) {
			return false;
		}
		int[] countarr = new int[256];
		for(int i=0; i<word1.length(); i++) {
			countarr[word.charAt(i)]++;           //incrementing char of word
			countarr[word1.charAt(i)]--;           //decrementing char of word
		}
		for (int j=0; j<countarr.length; j++) {
			if(countarr[j] != 0) {
				return false;
			}
		}
		return true;
	
	}
}
