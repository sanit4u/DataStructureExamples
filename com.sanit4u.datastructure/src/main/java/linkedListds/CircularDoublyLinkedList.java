package linkedListds;

import linkedListds.DoubleLinkedList.Node;

public class CircularDoublyLinkedList<T> {

	private Node head, tail = null;

	void pushAtEnd(T data) {

		Node node = new Node(data);
		if (head == null) {

			head = tail = node;

			head.next = head;
			head.previous = head;
			return;
		}

		tail.next = node;
		node.previous = tail;
		tail = node;
		tail.next = head;

		head.previous = tail;
	}

	void reverse() {
		Node current = head;
		Node prev = null, next = null;

		while (current.next != head) {

			prev = current.previous;
			next = current.next;

			current.previous = next;
			current.next = prev;

			current = next;
		}

		prev = current.previous;
		next = current.next;

		current.previous = next;
		current.next = prev;

		head = current;
	}

	@Override
	public String toString() {
		Node current = this.head;

		StringBuilder sb = new StringBuilder();

		while (current.next != this.head) {
			sb.append(current.data);
			current = current.next;
			sb.append("<-->");
		}

		sb.append(current.data);

		return sb.toString();
	}

	static class Node<T> {

		private T data;
		private Node next;
		private Node previous;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}
}
