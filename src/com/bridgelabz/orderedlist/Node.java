package com.bridgelabz.orderedlist;

public class Node<K> {
	Node next;
	Integer data;
	public Node(Integer data) {
		this.next = null;
		this.data = data;
		OrdereList.size++;
	}
	
}
