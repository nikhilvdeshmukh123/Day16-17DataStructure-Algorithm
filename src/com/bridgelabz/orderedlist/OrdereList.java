package com.bridgelabz.orderedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class OrdereList<K> {
    
	private K k;
	Node head;
	static int size;
	public OrdereList(K k) {
		this.k = k;
		linkedList();
	}


	private Integer[] readFileIntegers(String filename) {
		Integer[] integers;
		String text = "";
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
	
	private void linkedList() {
		
		String fileName = "C:\\Users\\SR COMPUTER\\Documents\\BridzeLabs\\RFP\\Day16-17\\src\\com\\bridgelabz\\orderedlist\\example.txt";
		Integer[] integers = readFileIntegers(fileName);
		for(Integer integer: integers) {
			if(head == null) {
				head = new Node(integer);
			}
			else {
			Node currNode = head;
			while(currNode.next !=null) {
				currNode = currNode.next;
			}
			 currNode.next = new Node(integer);
			}
		}
			
		}
		
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	
	public boolean search() {
		if (isEmpty()) {
			int a = (int)k;
			addFirst(a);
			return false;
		}
		Node currNode = head;
		while (currNode.data != k) {
			if (currNode.next == null) {
				int a = (int)k;
				addFirst(a);
				return false;
			}
			currNode = currNode.next;
		}
		int a = (int)k;
		delete(a);
		return true;
	}
	
	public boolean search(Integer data) {
		if (isEmpty()) {
			return false;
		}
		Node currNode = head;
		while (currNode.data.equals(data)) {
			if (currNode.next == null) {
				return false;
			}
			currNode = currNode.next;
		}
		return true;
	}
	public void addFirst(Integer data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}
    
	public void append(Integer data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			return;
		}

		Node currNode = head;
		while (currNode.next != null) {
			currNode = currNode.next;
		}
		currNode.next = newNode;
	}
	
	public void deleteFirst() {
		if (isEmpty()) {
			return;
		}
		head = head.next;
		size--;
	}

	public void deleteLast() {
		if (isEmpty()) {
			return;
		}
		size--;
		if (head.next == null) {
			head = null;
			return;
		}
		Node currNode = head;
		while (currNode.next.next != null) {
			currNode = currNode.next;
		}
		currNode.next = null;
	}
	
	public void delete(Integer data) {
		if(search(data)) {
			size--;
			if(head.data == data) {
				head = head.next;
				return;
			}
			Node currNode = head;
			while(currNode.next.data != data) {
				currNode = currNode.next;
			}
			Node temp = currNode.next.next;
			currNode.next = temp;
			
		}
	}

	public void insertAfter(Integer element, Integer data) {
		Node currNode = head;
		if (search(element)) {
			while (currNode.data != element) {
				currNode = currNode.next;
			}
			Node node1 = new Node(data);
			Node temp = currNode.next;
			currNode.next = node1;
			node1.next = temp;
		}
	}
	public void ascOrder() {
		if(isEmpty()) {
			return;
		}
		int exchanged =1;
		while(exchanged != 0) {
			Node currNode = head;
			exchanged = 0;
			while(currNode.next != null) {
				if(currNode.data > currNode.next.data) {
					int temp =currNode.next.data;
					currNode.next.data = currNode.data;
					currNode.data = temp;
		            exchanged++;   
				}
				currNode = currNode.next;
			}
			
		}
	}
	public void insertBetween(Integer element1, Integer element2, Integer data) {
		if (head == null || head.next == null) {
			// System.out.println("List contain only one element. So data can't be inserted
			// between one number.");
			return;
		}

		Node currNode = head;
		while (currNode.data != element1 || currNode.next.data != element2) {
			if (currNode.next.next == null) {
				break;
			}
			currNode = currNode.next;
		}
		if (currNode.data == element1 && currNode.next.data == element2) {
			Node newNode = new Node(data);
			Node temp = currNode.next;
			currNode.next = newNode;
			newNode.next = temp;
		}
	}
	
	public void show() {
		if (isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + "  ");
			currNode = currNode.next;
		}
		// System.out.println("Null");
	}
	
	public void fileWrite() {
		File file = new File("C:\\Users\\SR COMPUTER\\Documents\\BridzeLabs\\RFP\\Day16-17\\src\\com\\bridgelabz\\orderedlist\\example.txt");
		try {
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			Node currNode = head;
			while (currNode != null) {
				pw.print(currNode.data + ",");
				currNode = currNode.next;
			}
			pw.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
	
}
