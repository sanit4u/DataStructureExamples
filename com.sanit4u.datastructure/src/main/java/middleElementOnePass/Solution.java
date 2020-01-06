package middleElementOnePass;

import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {

		Solution sol = new Solution();

		LinkedList linkedList = sol.new LinkedList();
		Node head = linkedList.head();

		linkedList.add(sol.new Node("1"));
		linkedList.add(sol.new Node("2"));
		linkedList.add(sol.new Node("3"));
		linkedList.add(sol.new Node("4"));
		linkedList.add(sol.new Node("5"));

		Node middle = getMiddle(head);

		System.out.println(middle);
		System.out.println("Element at index 4 : "
				+ getElementAtIndex(linkedList, 4));
		getElementNth2LastIndex(linkedList, 1);
	}

	private static Node getMiddle(Node head) {
		Node middle = head;

		Node current = head;

		int length = 0;

		while (current.next() != null) {
			length++;
			if (length % 2 == 0) {
				middle = middle.next();
			}
			current = current.next();
		}

		if (length % 2 == 1) {
			middle = middle.next;
		}
		return middle;
	}

	private static Node getElementAtIndex(LinkedList linkedList, int index) {

		if (null == linkedList) {
			return null;
		}

		Node head = linkedList.head();

		if (index == 0 && head.next() == null) {
			return null;
		}

		Node current = head;

		int length = 0;

		while (current.next() != null) {

			if (current == head) {
				current = head.next();
			}

			current = current.next();
			length++;

			if (length == index) {
				break;
			}
			// return current;
		}

		return current;

	}

	private static void getElementNth2LastIndex(LinkedList linkedList, int nth) {

		if (null == linkedList) {
			return;
		}

		Node head = linkedList.head();

		if (nth == 0 && head.next() == null) {
			return;
		}

		Node current = head;

		int length = 0;

		while (current.next() != null) {

			if (current == head) {
				current = head.next();
			}

			current = current.next();
			length++;

			if (length >= nth) {
				System.out.print(current + ",");

			}
			// return current;
		}

	}

	public class LinkedList {
		private Node head;
		private Node tail;
		private int lentgh = 0;

		public LinkedList() {
			this.head = new Node("Head");
			this.tail = this.head;
			this.lentgh++;
		}

		public Node head() {
			return this.head;
		}

		public Node tail() {
			return this.tail;
		}

		public void add(final Node node) {
			this.tail.next = node;
			this.tail = node;
			this.lentgh++;
		}

		public int size() {
			return this.lentgh;
		}
	}

	class Node {
		private String data;
		private Node next;

		public Node(final String data) {
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return this.data;
		}
	}
}
