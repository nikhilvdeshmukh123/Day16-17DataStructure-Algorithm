package com.bridgelabz.hashingfunc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HashFunc {
	Node[] table;
	Integer[] integerArray;
	static final int bucketSize = 11;
	
	public HashFunc() {
		this.table = new Node[bucketSize];
		integerArray = readFileIntegers();
	}
	
	private Integer[] readFileIntegers() {
		Integer[] integers;
		String text = "";
		String filename = "C:\\Users\\SR COMPUTER\\Documents\\BridzeLabs\\RFP\\Day16-17\\src\\com\\bridgelabz\\hashingfunc\\example.txt";
		try {
			Scanner s = new Scanner(new File(filename));
			while(s.hasNextLine()) {
				text = text + s.next() + ",";
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		String[] integersArray = text.split(",");
		integers = new Integer[integersArray.length];
		int index =0;
		for(String integer: integersArray) {
			integers[index] = Integer.parseInt(integer);
			index++;
		}
		return integers;
	}
	
	public void hashTable() {
		for (int i = 0; i < integerArray.length; i++) {
			int bucketIndex = Math.abs(integerArray[i] % bucketSize);
			if (table[bucketIndex] == null) {
				table[bucketIndex] = new Node(integerArray[i]);
			} else {
				Node currNode = table[bucketIndex];
				while (currNode != null) {
					if(currNode.next == null) {
						currNode.next = new Node(integerArray[i]);
						break;
					}
					currNode = currNode.next;
					
				}
				
			}
		}
	}
	
	public void showTable() {
		if (isEmpty()) {
			return;
		} else {
			for (Node element : table) {
				Node currNode =element;
				while (currNode != null) {
					System.out.print(currNode.data + " " );
					currNode = currNode.next;
				}
				System.out.println();
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
			}
		}
	}
	
	
	
	private boolean isEmpty() {
		for (Node element : table) {
			if (element != null) {
				return false;
			}
		}
		return true;
	}
	
	public void fileWrite() {
		File file = new File("C:\\\\Users\\\\SR COMPUTER\\\\Documents\\\\BridzeLabs\\\\RFP\\\\Day16-17\\\\src\\\\com\\\\bridgelabz\\\\hashingfunc\\\\example.txt");
		try {
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			if (isEmpty()) {
				return;
			} else {
				for (Node element : table) {
					Node currNode =element;
					while (currNode != null) {
						pw.print(currNode.data + " " );
						currNode = currNode.next;
					}
					pw.println();
					pw.println("|||||||||||||||||||||||||||||||||||||||||||||");
				}
			}
			pw.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
	
	
}
