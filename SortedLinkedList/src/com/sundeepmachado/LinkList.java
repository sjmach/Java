package com.sundeepmachado;

class LinkList {

	static Node head;

	public boolean isEmpty() {
		return (head == null);
	}

	public void insert(int id, int x) {
		if (head == null || head.data > x) {
			head = new Node(id, x);
		} else {
			Node p = head;
			while (p.next != null) {
				if (p.next.data > x)
					break;
				p = p.next;
			}
			p.next = new Node(id, x, p.next);
		}

	}

	public void displayList() {
		{
			Node current = head;
			while (current != null) {
				current.displayNode();
				current = current.next;
			}

		}

	}
}