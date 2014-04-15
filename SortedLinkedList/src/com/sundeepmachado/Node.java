package com.sundeepmachado;

public class Node {
	int id;
	int data;
	Node next;

	public Node(int id, int data) {
		this.data = data;
		this.id = id;

	}

	Node(int id, int data, Node next) {
		this.id = id;
		this.data = data;
		this.next = next;
	}

	public void displayNode() {
		System.out.print(data + " ");
	}

}
