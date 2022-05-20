package com.bridgelabz.unorderedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnorderedList<K> {
    
	private K k;
	Node head;
	static int size;
	public UnorderedList(K k) {
		this.k = k;
		linkedList();
	}


	private String[] readFileString(String filename) {
		String[] words;
		String text = "";
		try {
			Scanner s = new Scanner(new File(filename));
			while(s.hasNextLine()) {
				text = text + s.next() + " ";
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		words = text.split(",");
		return words;
	}
	
	public void linkedList() {
		
		String fileName = "C:\\Users\\SR COMPUTER\\Documents\\BridzeLabs\\RFP\\Day16-17\\src\\com\\bridgelabz\\unorderedlist\\example.txt";
		String[] words = readFileString(fileName);
		for(String word: words) {
			if(head == null) {
				head = new Node(word);
			}
			else {
			Node currNode = head;
			while(currNode.next !=null) {
				currNode = currNode.next;
			}
			 currNode.next = new Node(word);
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
			return false;
		}
		Node currNode = head;
		while (currNode.data.hashCode() != ((String)k).hashCode()) {
			if (currNode.next == null) {
				return false;
			}
			currNode = currNode.next;
		}
		return true;
	}
	
	public boolean search(String data) {
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
	public void addFirst(String data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}
    
	public void append(String data) {
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
	
	public void delete(String data) {
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

	public void insertAfter(String element, String data) {
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

	public void insertBetween(String element1, String element2, String data) {
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
	
	
}
