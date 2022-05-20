package com.bridgelabz.palindrome;

public class Palindrome<K> {
	
	private K k;
	Node head;
	static int size;
	
	public Palindrome(K k) {
		this.k = k;
	}
	
	public boolean palindromeChecker() {
		String[] s = ((String)k).split("(?!^)");
		if(s.length == 1) {
			return true;
		}
		for(String letter: s) {
			addFront(letter);
		}
		while(head.next != null) {
			if(removeFront().hashCode() != removeRear().hashCode()) {
				return false;
			}
			if(head == null) {
				return true;
			}
		}
		return true;
	}
	
	private boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	
	private void addFront(String letter) {
		Node newNode = new Node(letter);
		if (isEmpty()) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}
	
	public void addRear(String letter) {
		Node newNode = new Node(letter);
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
	
	public String removeFront() {
		if (isEmpty()) {
			return " ";
		}
		Node temp = head;
		head = head.next;
		size--;
		return temp.letter;
	}
	
	
	public String removeRear() {
		if (isEmpty()) {
			return " ";
		}
		size--;
		if (head.next == null) {
			Node temp = head;
			head = null;
			return temp.letter;
		}
		Node currNode = head;
		while (currNode.next.next != null) {
			currNode = currNode.next;
		}
		Node temp = currNode.next;
		currNode.next = null;
		return temp.letter;
	}
	
	public int getSize() {
		System.out.println();
		return size;
	}
	
}
