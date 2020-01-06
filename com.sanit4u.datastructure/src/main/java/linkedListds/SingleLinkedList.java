package linkedListds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleLinkedList<T extends Comparable> {

	private Node head;

	public void append(T data) {

		if (head == null) {
			head = new Node(data);
			return;
		}

		Node current = new Node(data);
		tail().next = current;
	}

	public Node getHead() {
		return head;
	}

	private Node tail() {
		Node tail = head;

		while (tail.next != null) {
			tail = tail.next;
		}

		return tail;
	}

	public void reverseIterativey() {
		Node current = head;
		Node forward = null;
		Node previous = null;

		while (current.next != null) {

			forward = current.next;

			current.next = previous;
			previous = current;

			current = forward;
		}

		head = current;
		head.next = previous;

	}

	public void sort() {

		List<T> list = new ArrayList<T>();

		Node current = this.head;

		while (current != null) {
			list.add((T) current.data);
			current = current.next;
		}

		Collections.sort(list);

		head = null;
		for (T t : list) {
			this.append(t);
		}
	}

	@Override
	public String toString() {

		Node current = this.head;

		StringBuilder sb = new StringBuilder();

		while (current != null) {
			sb.append(current.data);
			current = current.next;
			if (current != null) {
				sb.append("-->");
			}
		}

		return sb.toString();
	}

	public static String print(Node head) {

		Node current = head;

		StringBuilder sb = new StringBuilder();

		while (current != null) {
			sb.append(current.data);
			current = current.next;
			if (current != null) {
				sb.append("-->");
			}
		}

		return sb.toString();
	}

	/*
	 * 2 -> 4 -> 3 5 -> 6 -> 4 7 0 8
	 */
	static Node add2IntLinkedList(Node t1, Node t2) {
		Node fake = new Node(0);
		Node ref = fake;
		Node p1 = t1;
		Node p2 = t2;

		int carry = 0;
		while (p1 != null || p2 != null) {
			int sum = carry;
			if (p1 != null) {
				sum = sum + (int) p1.data;
				p1 = p1.next;
			}

			if (p2 != null) {
				sum = sum + (int) p2.data;
				p2 = p2.next;
			}

			if (sum > 9) {
				carry = 1;
				sum = sum % 10;
			} else {
				carry = 0;
			}

			Node res = new Node(sum);
			ref.next = res;
			ref = ref.next;
		}

		// add all the carry
		if (carry > 0) {
			Node car = new Node(carry);
			ref.next = car;
		}

		return fake.next;
	}

	public static boolean detectCycle(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if there is a cycle exists or not. if it exists, then it deletes the
	 * cycle
	 * 
	 * 1. Checks for the length of the loop (no. of nodes in the loop ; K) <br>
	 * 2. Find the first node of the loop. take two ptr; ptr1= head, ptr2= Kth Node
	 * 3. Find the last node of the loop and unlink the next pointer. <br>
	 * 
	 * 
	 * @param node Head
	 */
	public static void detectCycleAndRemoveLoop(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				removeCycle(slow, head);
			}
		}

	}

	/**
	 * 1. Checks for the length of the loop (no. of nodes in the loop ; K) <br>
	 * 2. Find the first node of the loop. take two ptr; ptr1= head, ptr2= Kth Node
	 * 3. Find the last node of the loop and unlink the next pointer. <br>
	 * 
	 * @param slow
	 * @param head
	 */
	private static void removeCycle(Node slow, Node head) {

		Node ptr1 = slow, ptr2 = slow;

		// length of the loop
		int k = 1;
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			k++;
		}

		// finding the kth node
		ptr1 = head;
		ptr2 = head;
		for (int i = 0; i < k; i++) {
			ptr2 = ptr2.next;
		}

		// find the enrty node of the loop
		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		// pointer to the last node in the loop
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
		}

		// unlink
		ptr1.next = null;
	}

	public static class Node<T> {
		private Node next;
		private T data;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

}
