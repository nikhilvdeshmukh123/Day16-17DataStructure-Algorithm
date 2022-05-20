package com.bridgelabz.permutationstring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationOfString {
	
    // using Collections
    public static void findPermutations(String str) {
    	
        if (str == null || str.length() == 0) {
            return;
        }
        
        List<String> partial = new ArrayList<>();
        partial.add(String.valueOf(str.charAt(0)));    // initialize the list with the first character of the string
        for (int i = 1; i < str.length(); i++)
        {
            for (int j = partial.size() - 1; j >= 0 ; j--)
            {
                // remove current partial permutation from the ArrayList
                String s = partial.remove(j);
 
                // Insert the next character of the specified string at all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed strings in the list
 
                for (int k = 0; k <= s.length(); k++)
                {
                    // Advice: use StringBuilder for concatenation
                    partial.add(s.substring(0, k) + str.charAt(i) + s.substring(k));
                }
            }
        }
 
        System.out.println(partial);
    }
   
    public static void main(String[] args) {
    	System.out.println("Enter a string : ");
    	Scanner str1 = new Scanner(System.in);
    	String str = str1.next();
        findPermutations(str);
    }
}
